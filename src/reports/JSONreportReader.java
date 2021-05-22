package reports;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONreportReader implements JSONReader {
	
	public String json;
	
	public JSONreportReader(String json) {
		this.json = json;
	}
	
	public String readJson() throws IOException {
        
        return new String(Files.readAllBytes(Paths.get(json)));
	}

}
