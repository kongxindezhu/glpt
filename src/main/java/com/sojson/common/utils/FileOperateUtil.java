package com.sojson.common.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;


/**
 * 文件操作
 */
public class FileOperateUtil {

    /**
     * @param file
     *            //文件对象
     * @param filePath
     *            //上传路径
     * @param fileName
     *            //文件名
     * @return 文件名
     */
    public static String fileUp(MultipartFile file, String filePath, String fileName) {
        String extName = ""; // 扩展名格式：
        try {
            if (file.getOriginalFilename().lastIndexOf(".") >= 0) {
                extName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            }
            copyFile(file.getInputStream(), filePath, fileName + extName).replaceAll("-", "");
        } catch (IOException e) {
            System.out.println(e);
        }
        return fileName + extName;
    }

    /**
     * 写文件到当前目录的upload目录中
     * 
     * @param in
     * @param fileName
     * @throws IOException
     */
    private static String copyFile(InputStream in, String dir, String realName) throws IOException {
        File file = new File(dir, realName);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
        }
        System.out.println(file.getAbsolutePath());
        FileUtils.copyInputStreamToFile(in, file);
        return realName;
    }

    /**
     * @param request
     *            //requst请求
     * @param filePath
     *            //上传路径
     * @param fileName
     *            //文件名
     * @return 文件名
     * @throws IOException
     * @throws IllegalStateException
     */
    public static String upload(HttpServletRequest request, String filePath, String fileName)
            throws IllegalStateException, IOException {
        String extName = ""; // 扩展名格式：
        String path = "";
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        // 判断 request 是否有文件上传,即多部分请求
        if (multipartResolver.isMultipart(request)) {
            // 转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            // 取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                // 取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                if (file != null) {
                    // 取得当前上传文件的文件名称
                    String myFileName = file.getOriginalFilename();
                    // 如果名称不为“”,说明该文件存在，否则说明该文件不存在
                    if (myFileName.trim() != "") {
                        // 重命名上传后的文件名
                        if (file.getOriginalFilename().lastIndexOf(".") >= 0) {
                            extName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                        }
                        // 定义上传路径
                        path = filePath + "/" + fileName + extName;
                        // System.out.println("---------------------");
                        // System.out.println(path);
                        // System.out.println("---------------------");
                        File localFile = new File(path);
                        file.transferTo(localFile);
                    }
                }
            }

        }
        return extName;
    }
    
    

    /**
     * @param request
     *            //requst请求
     * @param filePath
     *            //上传路径
     * @param fileName
     *            //文件名
     * @return 文件名
     * @throws IOException
     * @throws IllegalStateException
     */
    public static String[] uploadMultiple(HttpServletRequest request, String filePath, String[] fileName)
            throws IllegalStateException, IOException {
        String[] extName = new String[fileName.length]; // 扩展名格式：
        String path = "";
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        // 判断 request 是否有文件上传,即多部分请求
        if (multipartResolver.isMultipart(request)) {
            // 转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            // 取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            int i = 0;
            while (iter.hasNext()) {
                // 取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                if (file != null) {
                    // 取得当前上传文件的文件名称
                    String myFileName = file.getOriginalFilename();
                    // 如果名称不为“”,说明该文件存在，否则说明该文件不存在
                    if (myFileName.trim() != "") {
                        // 重命名上传后的文件名
                        if (file.getOriginalFilename().lastIndexOf(".") >= 0) {
                            extName[i] = file.getOriginalFilename()
                                    .substring(file.getOriginalFilename().lastIndexOf("."));
                        }
                        // 定义上传路径
                        fileName[i] = fileName[i].replace(extName[i], "");
                        path = filePath + "/" + fileName[i] + extName[i];
//                        path = fileName[i] + extName[i];
                        File localFile = new File(path);
                        file.transferTo(localFile);
                        System.out.println(localFile.getAbsolutePath());
                    }
                }
                i++;
            }

        }
        return extName;
    }

    /**
     * 从request那里得到所有MultipartFile
     */
    public static List<MultipartFile> getMultipartFileFromRequest(HttpServletRequest request)
            throws IllegalStateException, IOException {
        
        List<MultipartFile> fileList = new ArrayList<MultipartFile>();
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        // 判断 request 是否有文件上传,即多部分请求
        if (multipartResolver.isMultipart(request)) {
            // 转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            // 取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                MultipartFile file = multiRequest.getFile(iter.next());
                System.out.println(file.getName()+"11111111111");
                if (file != null && file.getSize() > 0) {
                    fileList.add(file);
                }
            }
        }
        return fileList;
    }
    /**
     * @Description:删除文件
     */
    public static void deleteFile(String bucketName, String key) {
        return;
    }
    
    /**
     * 从request那里得到所有MultipartFile
     */
    public static MultipartFile getMultipartFileByName(HttpServletRequest request,String name)
            throws Exception {
        MultipartFile file=null;
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        // 判断 request 是否有文件上传,即多部分请求
        if (multipartResolver.isMultipart(request)) {
            // 转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            // 取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                file = multiRequest.getFile(iter.next());
                if (file != null&&file.getName().equals(name)) {
                    return file;
                }
            }
        }
        return file;
    }
    
    /**
     * 根据文件得到后缀名
     * @param file
     * @return
     */
    public static String getExtNameByString(String file){
        String extName="";
        if (file.lastIndexOf(".") >= 0){
            extName = file.substring(file.lastIndexOf("."));
        }
        return extName;
    }
    
    public static String getExtName(MultipartFile file){
        String extName="";
        if (file.getOriginalFilename().lastIndexOf(".") >= 0){
            extName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        }
        return extName;
    }

    /**   
     * 删除单个文件   
     * @param   fileName    被删除文件的文件名   
     * @return 单个文件删除成功返回true,否则返回false   
     */   
	public static boolean deleteFile(String fileName) {
		File file = new File(fileName);
		if (file.isFile() && file.exists()) {
			file.delete();
			return true;
		}
		return false;
	}

	/**
	 * 删除目录（文件夹）以及目录下的文件
	 * 
	 * @param dir
	 *            被删除目录的文件路径
	 * @return 目录删除成功返回true,否则返回false
	 */
	public static boolean deleteDirectory(String directorydir) {
		// 如果dir不以文件分隔符结尾，自动添加文件分隔符
		if (!directorydir.endsWith(File.separator)) {
			directorydir = directorydir + File.separator;
		}
		File dirFile = new File(directorydir);
		// 如果dir对应的文件不存在，或者不是一个目录，则退出
		if (!dirFile.exists() || !dirFile.isDirectory()) {
			// "删除目录失败"+name+"目录不存在！"
			return false;
		}
		boolean flag = true;
		// 删除文件夹下的所有文件(包括子目录)
		File[] files = dirFile.listFiles();
		for (int i = 0; i < files.length; i++) {
			// 删除子文件
			if (files[i].isFile()) {
				flag = deleteFile(files[i].getAbsolutePath());
				if (!flag) {
					break;
				}
			}
			// 删除子目录
			else {
				flag = deleteDirectory(files[i].getAbsolutePath());
				if (!flag) {
					break;
				}
			}
		}

		if (!flag) {
			// System.out.println("删除目录失败");
			return false;
		}

		// 删除当前目录
		if (dirFile.delete()) {
			// System.out.println("删除目录"+directorydir+"成功！");
			return true;
		} else {
			// System.out.println("删除目录"+directorydir+"失败！");
			return false;
		}
	}

	// 删除文件夹 folderPath 文件夹完整绝对路径
	public static void delFolder(String folderPath) {
		try {
			delAllFile(folderPath); // 删除完里面所有内容
			String filePath = folderPath;
			filePath = filePath.toString();
			java.io.File myFilePath = new java.io.File(filePath);
			myFilePath.delete(); // 删除空文件夹
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 删除指定文件夹下所有文件 path 文件夹完整绝对路径
	public static boolean delAllFile(String path) {
		boolean flag = false;
		File file = new File(path);
		if (!file.exists()) {
			return flag;
		}
		if (!file.isDirectory()) {// 判断该路径是否是一个目录
			return flag;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + "/" + tempList[i]);// 先删除文件夹里面的文件
				delFolder(path + "/" + tempList[i]);// 再删除空文件夹
				flag = true;
			}
		}
		return flag;
	}

	/*
	 * public static void main(String[] args) { //String fileName =
	 * "g:/temp/xwz.txt"; //DeleteFileUtil.deleteFile(fileName); String fileDir
	 * =
	 * "D:\\apache-tomcat-6.0.18\\webapps\\cyfy\\upload\\disk\\1245117448156\\JavaScript486.rar"
	 * ; //DeleteFileUtil.deleteDirectory(fileDir);
	 * 
	 * DeleteFileUtil.delete(fileDir); DeleteFileUtil t = new DeleteFileUtil();
	 * delFolder("c:/bb"); System.out.println("deleted");
	 * 
	 * }
	 */
	/******************************************************************************************************************/
	// 删除指定路径下所有空文件夹
	public static void main(String[] args) {
		// 要删除的目录 请勿以\\结尾，及最后一层目录后的分隔符不要
		String rootPath = "D:\\UsersMyEclipse10Space\\JYCRM\\WebRoot\\uploads";
		List<File> list = getAllNullDirectorys(new File(rootPath));
		// System.out.println("---------------" + list.size());
		/*
		 * for (int i = 0; i < list.size(); i++) {
		 * System.out.println(list.get(i).getPath()); }
		 */
		removeNullFile(list, rootPath);
	}

	/**
	 * 递归列出某文件夹下的最深层的空文件夹绝对路径，储存至list
	 * 
	 * @param root
	 * @return
	 */
	public static List<File> getAllNullDirectorys(File root) {
		List<File> list = new ArrayList<File>();
		File[] dirs = root.listFiles();
		if (dirs != null) {
			for (int i = 0; i < dirs.length; i++) {
				if (dirs[i].isDirectory() && dirs[i].listFiles().length == 0) {
					// System.out.println("name:" + dirs[i].getPath());
					list.add(dirs[i]);
				}
				if (dirs[i].isFile()) {
					// System.out.println("文件:"+dirs[i].getPath());
				}
				list.addAll(getAllNullDirectorys(dirs[i]));
			}
		}
		return list;
	}

	/**
	 * 由最深一层的空文件，向上（父文件夹）递归，删除空文件夹
	 * 
	 * @param list
	 * @param rootPath
	 */
	public static void removeNullFile(List<File> list, String rootPath) {
		if (list == null || list.size() == 0) {
			return;
		}
		List<File> plist = new ArrayList<File>();
		for (int i = 0; i < list.size(); i++) {
			File temp = list.get(i);
			if (temp.isDirectory() && temp.listFiles().length <= 0) {
				temp.delete();
				// System.out.println("parent:" +
				// temp.getParentFile().getPath());
				File pFile = temp.getParentFile();
				if (pFile.getPath().equals(rootPath)) {
					continue;
				}
				if (!plist.contains(pFile)) {// 父目录去重添加
					plist.add(pFile);
				}
			}
		}
		removeNullFile(plist, rootPath);
	}

	/**
	 * 下载
	 * 
	 * @author geloin
	 * @date 2012-5-5 下午12:25:39
	 * @param request
	 * @param response
	 * @param storeName
	 *            下载的文件名称(下载文件路径)
	 * @param contentType
	 * @param realName
	 *            下载后需要显示的文件名称
	 * @throws Exception
	 */
	public static void download(HttpServletRequest request,
			HttpServletResponse response, String storeName, String contentType,
			String realName) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		String ctxPath = request.getSession().getServletContext().getRealPath("/")+ "uploads/";
		String downLoadPath = ctxPath + storeName;

		long fileLength = new File(downLoadPath).length();

		response.setContentType(contentType);
		response.setHeader("Content-disposition", "attachment; filename="
				+ new String(realName.getBytes("gb2312"), "ISO-8859-1"));
		response.setHeader("Content-Length", String.valueOf(fileLength));

		bis = new BufferedInputStream(new FileInputStream(downLoadPath));
		bos = new BufferedOutputStream(response.getOutputStream());
		byte[] buff = new byte[2048];
		int bytesRead;
		while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
			bos.write(buff, 0, bytesRead);
		}
		bis.close();
		bos.close();
	}


}
