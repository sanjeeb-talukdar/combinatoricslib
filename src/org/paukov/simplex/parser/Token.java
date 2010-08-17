package org.paukov.simplex.parser;

/**
 * This class represents tokens
 * 
 */
public class Token {

    public enum TokenCode {
	INITIAL_LINE, VARIABLE, SUBJECT_TO, MAX, MIN, END, NUMBER, SIGNAL, MORE_EQUAL, LESS_EQUAL, EQUAL
    }

    private TokenCode id;
    private Object value;
    private String token;

    public Token(TokenCode id, Object value, String token) {
	super();
	this.id = id;
	this.value = value;
	this.token = token;
    }

    /**
     * @return the id
     */
    public TokenCode getId() {
	return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(TokenCode id) {
	this.id = id;
    }

    /**
     * @return the value
     */
    public Object getValue() {
	return value;
    }

    /**
     * @param value
     *            the value to set
     */
    public void setValue(Object value) {
	this.value = value;
    }

    /**
     * @return the token
     */
    public String getToken() {
	return token;
    }

    /**
     * @param token
     *            the token to set
     */
    public void setToken(String token) {
	this.token = token;
    }

    public String toString() {
	return "Token id=<" + id + ">, token=<" + token + ">, value=<" + value
		+ ">";
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((token == null) ? 0 : token.hashCode());
	return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Token other = (Token) obj;
	if (token == null) {
	    if (other.token != null)
		return false;
	} else if (!token.equals(other.token))
	    return false;
	return true;
    }
}