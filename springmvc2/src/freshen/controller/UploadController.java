package freshen.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	
	@RequestMapping("dowloadFile")
	public ResponseEntity<byte[]> dowloadFile(HttpServletRequest request) throws IOException{
		String path = request.getSession().getServletContext().getRealPath("uploadfiles");
		
		File file =new File(path,"Sunset.jpg");
		HttpHeaders h = new HttpHeaders();
		h.setContentDispositionFormData("attachment", "aa.jpg");
		h.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		ResponseEntity<byte[]> et =new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), h, HttpStatus.CREATED);
		return et;
	}
	
	@ResponseBody
	@RequestMapping("/upload")
	public String upload(@RequestParam(value = "file", required = false) MultipartFile[] file, HttpServletRequest request, ModelMap model){
		//System.out.println("upload"+file.getName()+"  "+files.getSize());
		
		String path = request.getSession().getServletContext().getRealPath("uploadfiles");  
		System.out.println(path);
		try {
			for (int i = 0; i < file.length; i++) {
				File f = new File(path,file[i].getOriginalFilename());
				file[i].transferTo(f);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "ok";
	}
}
