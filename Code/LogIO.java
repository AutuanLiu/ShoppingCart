import java.io.*;

public class LogIO 
{
    private static File log=new File("record.txt");//创建文件对象
    public static void fprint(String m) 
    { 
        try 
        	{ 
             OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(log),"utf-8"); 
             if (!log.exists()) //如果不存在文件对象，则创建之
             { 
                log.createNewFile(); 
             } 
            else  //若已经存在，则删除，避免多次写入数据
                log.delete();      
            write.write(m); //向文件写入数据
            write.close(); 
        	} 
        catch (Exception e) 
        { 
            System.out.println("写文件内容操作出错"); 
            e.printStackTrace(); 
        } 
    } 
    public static String fwrite() 
    	{ 
         String m = ""; 
         try 
        	{   
             if(log.isFile()&&log.exists())
            	{ 
                	InputStreamReader read = new InputStreamReader(new FileInputStream(log),"utf-8"); 
                	BufferedReader reader=new BufferedReader(read); 
                	//读取文件数据
                	String line; 
                	while ((line = reader.readLine()) != null) { 
                		m+=line+"\n"; 
                }   
                read.close(); 
            } 
        } 
        catch (Exception e) 
        { 
            System.out.println("读取文件内容操作出错"); 
            e.printStackTrace(); 
        } 
        return m; 
    	} 
}



