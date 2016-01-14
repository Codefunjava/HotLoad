package hotLoadClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author seven
 *	�������
 */
public class MyClassLoads extends ClassLoader {
	
	//������˽�л�,��ֹʹ����ֱ������ʵ��
	private MyClassLoads() {}
	
	//��ȡMyClassLoads��Ψһ����
	public static MyClassLoads GetInstance() {
		return new MyClassLoads();
	}

		
	/**
	 * @param classPaht
	 * @return Object
	 * �ȼ����µ�Class��
	 */
	public Object FindNewClass(String classPaht) {
		try {
			byte[] b = getBytes(classPaht);
			return defineClass(null, b, 0, b.length).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * @param o
	 * @return T
	 * ��װ���������
	 */
	@SuppressWarnings("unchecked")
	public static <T> T ReLoadClass(Object o) {
		return (T) o;
	}

	
	/**
	 * @param filename
	 * @return Byte[]
	 * @throws IOException
	 *  ����class�ļ���Byte
	 */
	private byte[] getBytes(String filename) throws IOException {
		File file = new File(filename);
		byte raw[] = new byte[(int) file.length()];
		FileInputStream fin = new FileInputStream(file);
		fin.read(raw);
		fin.close();
		return raw;
	}
}
