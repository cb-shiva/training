import java.nio.file.*;
import java.io.*;
public class PathTest {

	public static void print_all_file_names(Path currentDirectory) throws IOException{
		DirectoryStream<Path> stream = Files.newDirectoryStream(currentDirectory);
    	for (Path file: stream) {
    		if(file.toFile().isDirectory()){
    			print_all_file_names(file);
    		}
    		else{
       			System.out.println(file.getFileName());
       		}
    	}
	}

	public static void main(String[] args) throws IOException{
		Path p1 = Paths.get("/test/foo");
		Path p2 = Paths.get(System.getProperty("user.home"),"logs", "foo.log");
		System.out.println(p1.getFileName());
		System.out.println(p2.getFileName());

		Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
		for (Path name: dirs) {
    		System.err.println(name);
		}
		Path currentDirectory = Paths.get("");
		print_all_file_names(currentDirectory);
	}
}