package stardewtracker;

public class SaveFile {
	
	private String SaveFileName;
	private String SavePath;
	
	public SaveFile(String SaveFileName, String SavePath) {
		this.SaveFileName = SaveFileName;
		this.SavePath = SavePath;
	}
	
	public String getName() {
		return this.SaveFileName;
	}
	
	public String getPath() {
		return this.SavePath;
	}

}
