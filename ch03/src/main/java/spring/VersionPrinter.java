package spring;

public class VersionPrinter {
	private int majorVersion;
	private int minorVersion;
	
	public void setMajorVersion(int majorVersion) {
		this.majorVersion = majorVersion;
	}
	public void setMinorVersion(int minorVersion) {
		this.minorVersion = minorVersion;
	}
	
	public void print() {
		System.out.printf("version %d.%d\n\n",majorVersion,minorVersion);
	}
}
