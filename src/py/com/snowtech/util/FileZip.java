package py.com.snowtech.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileZip {
	public static void compress(final String origin, final String target) {
		// Wrap a FileOutputStream around a ZipOutputStream
		// to store the zip stream to a file. Note that this is
		// not absolutely necessary
		FileOutputStream fileOutputStream;
		try {
			File inputFile = new File(origin);
			fileOutputStream = new FileOutputStream(target);
			ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
			
			// a ZipEntry represents a file entry in the zip archive
			// We name the ZipEntry after the original file's name
			ZipEntry zipEntry = new ZipEntry(inputFile.getName());
			zipOutputStream.putNextEntry(zipEntry);

			FileInputStream fileInputStream = new FileInputStream(inputFile);
			byte[] buf = new byte[1024];
			int bytesRead;

			// Read the input file by chucks of 1024 bytes
			// and write the read bytes to the zip stream
			while ((bytesRead = fileInputStream.read(buf)) > 0) {
				zipOutputStream.write(buf, 0, bytesRead);
			}

			// close ZipEntry to store the stream to the file
			zipOutputStream.closeEntry();
			zipOutputStream.close();
			fileOutputStream.close();
			fileInputStream.close();
			
			System.out.println("Regular file :" + inputFile.getCanonicalPath()+" is zipped to archive :" + target);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String... args) {
		if (args.length != 2) {
			System.err.println("Uso: FileZip origenFile targetFile");
			System.exit(-1);
		}
		FileZip.compress(args[0], args[1]);
	}
}
