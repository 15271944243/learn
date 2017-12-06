/**
 * @author 晓晨
  * 2017年8月4日下午8:55:59
 */
package com.uploadFile.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileUploadController {

	//访问单文件路径
	@RequestMapping(value="/upload",method=RequestMethod.GET)
	public String upload(){
		return "fileUpload";
	}
	
	//访问多文件路径
	@RequestMapping(value="/upload/batch",method=RequestMethod.GET)
	public String batchUpload(){
		return "filesBatchUpload";
	}
	
	
	/**
	 *  上传文件实现
	 * @param file
	 * @return
	 */
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	@ResponseBody
	public String upload(@RequestParam("fileName") MultipartFile file){
		if(!file.isEmpty()){
			BufferedOutputStream out;
			try {
				out = new BufferedOutputStream(new FileOutputStream(
						new File(file.getOriginalFilename())));
				try {
					out.write(file.getBytes());
					out.flush();
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
					return "上传失败,"+e.getMessage();
				}	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return "上传失败,"+e.getMessage();
			}
			return "上传成功";
		}else{
			return "上传失败，因为文件是空的";
		}
	}
	
	//多文件上传  将request转换为MultipartHttpServletRequest并得到
	//前段页面中file 名称组合
	@RequestMapping(value="/upload/batch",method=RequestMethod.POST)
	public @ResponseBody String batchUpload(HttpServletRequest request) {
		List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("fileName");
		BufferedOutputStream out = null;
		MultipartFile file = null;
		for (int i = 0; i < files.size(); i++) {
			file = files.get(i);
			if (!file.isEmpty()) {
				try {
					byte[] bytes = file.getBytes();
					out = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
					out.write(bytes);
					out.flush();
					out.close();
				} catch (IOException e) {
					out = null;
					return "upload" + i + "文件报" + e.getMessage();
				}
			}else{
				return "上传失败因为"+i+"文件是空";
			}
		}
		return "上传成功";
	}
}
