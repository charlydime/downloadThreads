package net.atos.crojo.downloadThreads.services;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Component;

import net.atos.crojo.downloadThreads.services.obs.DescargaObs;
import net.atos.crojo.downloadThreads.services.obs.Subject;



@Component
public class Downloader implements Runnable {
	
	private String urlName;
	private String destName;
	
	private DescargaObs obs;
	private Subject managerObs;

	


	@Override
	public void run() {
		
		
	    try {
	    	this.managerObs = new Subject();
			
			this.obs = new DescargaObs(managerObs);
			
	    	
            URL url = new URL(urlName);
            HttpURLConnection httpConnection = (HttpURLConnection) (url.openConnection());
            long completeFileSize = httpConnection.getContentLength();

            java.io.BufferedInputStream in = new java.io.BufferedInputStream(httpConnection.getInputStream());
            java.io.FileOutputStream fos = new java.io.FileOutputStream(
                    destName);
            java.io.BufferedOutputStream bout = new BufferedOutputStream(
                    fos, 1024);
            byte[] data = new byte[1024];
            long downloadedFileSize = 0;
            int x = 0;
            while ((x = in.read(data, 0, 1024)) >= 0) {
                downloadedFileSize += x;

                // calculate progress
                final int currentProgress = (int) ((((double)downloadedFileSize) / ((double)completeFileSize)) * 100d);
                
                
                managerObs.setEstado("descarga: "+ this.destName+" progreso: " + currentProgress);

                // update progress 
                
                bout.write(data, 0, x);
            }
            bout.close();
            in.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
		
		
		
	}


	public String getUrlName() {
		return urlName;
	}


	public void setUrlName(String urlName) {
		this.urlName = urlName;
	}


	public String getDestName() {
		return destName;
	}


	public void setDestName(String destName) {
		this.destName = destName;
	}
	
	

}
