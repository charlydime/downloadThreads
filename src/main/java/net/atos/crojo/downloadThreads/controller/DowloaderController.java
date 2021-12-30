package net.atos.crojo.downloadThreads.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import net.atos.crojo.downloadThreads.services.Downloader;

@RestController
public class DowloaderController {
	
	
	Downloader dwnFile1;
	
	
	Downloader dwnFile2;
	
	
	Downloader dwnFile3;
	
	@GetMapping("/f1")
	 String initDowload() {
		
		Downloader dwnFile1 = new Downloader();
				
		Downloader dwnFile2 =new Downloader();
				
		dwnFile1.setUrlName("https://phoenixnap.dl.sourceforge.net/project/reactos/ReactOS/0.4.14/ReactOS-0.4.14-iso.zip");
		dwnFile1.setDestName("ReactOS-0.4.14-iso.zip");
		
		dwnFile2.setUrlName("https://downloads-global.3cx.com/downloads/debian10iso/debian-amd64-netinst-3cx.iso");
		dwnFile2.setDestName("debian-amd64-netinst-3cx.iso");
		
		Thread dwn1 = new Thread( dwnFile1 );
		dwn1.start();
		
		Thread dwn2 = new Thread( dwnFile2 );
		dwn2.start();
		
		
		
		return "Iniciado Descarga ver consola de spring";
		
	}

}
