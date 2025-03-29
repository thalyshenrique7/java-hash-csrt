package model;

/*
 * Created by @Thalys
 * 3-29-25 7:43 am
 * Nota Técnica 2018.005
 */
public class JavaHashGeneratorItem {

	public static final Long ID_CSRT_DEFAULT = 01L;
	public static final String CSRT_VALUE_DEFAULT = "G8063VRTNDMO886SFNK5LDUDEI24XJ22YIPO";
	public static final String KEY_ACCESS_DEFAULT = "41180678393592000146558900000006041028190697";

	private Long idCsrt;

	private String keyAccess;
	private String csrt;
	private String hashCsrt;

	public Long getIdCsrt() {
		return idCsrt;
	}

	public void setIdCsrt(Long idCsrt) {
		this.idCsrt = idCsrt;
	}

	public String getKeyAccess() {
		return keyAccess;
	}

	public void setKeyAccess(String keyAccess) {
		this.keyAccess = keyAccess;
	}

	public String getCsrt() {
		return csrt;
	}

	public void setCsrt(String csrt) {
		this.csrt = csrt;
	}

	public String getHashCsrt() {
		return hashCsrt;
	}

	public void setHashCsrt(String hashCsrt) {
		this.hashCsrt = hashCsrt;
	}

}
