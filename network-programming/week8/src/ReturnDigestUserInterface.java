public class ReturnDigestUserInterface {

	public static void main(String[] args) {
		//System.out.println(System.getProperty("user.dir"));
		String[] temp = {"data.bin", "data.txt"};
		for (String filename : temp) {		
            ReturnDigest dr = new ReturnDigest(filename);
			dr.start(); 

        try {
				dr.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		 
			StringBuilder result = new StringBuilder(filename);
			result.append(": ");
			byte[] digest = dr.getDigest();
			//result.append(DatatypeConverter.printHexBinary(digest));
			result.append(byteToHex(digest));
			System.out.println(result);
		} 
	}

	public static String byteToHex(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		for (byte b : bytes) {
            String st = String.format("%02X", b);
            sb.append(st); 
		}
		return sb.toString(); 		
	}
}