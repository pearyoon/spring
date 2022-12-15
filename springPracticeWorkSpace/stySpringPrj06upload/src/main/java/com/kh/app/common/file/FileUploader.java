package com.kh.app.common.file;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import com.kh.app.member.vo.MemberVo;

public class FileUploader {
	
	public static String upload(MemberVo vo, HttpServletRequest req) {
		
		String path = req.getSession().getServletContext().getRealPath("/resources/upload/");
		String originName = vo.getProfile().get(0).getOriginalFilename();
		String ext = originName.substring(originName.lastIndexOf(".") ,originName.length());
		
		String changeName = "profile_" + System.nanoTime() + ext;
		
		File target = new File(path + changeName);
		
		try {
			vo.getProfile().get(0).transferTo(target);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return changeName;
	}
	
}
