import java.util.Arrays;

public class Parser {
    private final String originalText;
    private String text[];
    private String transactionType;
    private String queryString;

    public Parser(String text) {
        this.originalText = text;
        this.text = text.split("[?=&]");
        this.transactionType = this.text[0].replaceFirst("[/]","");
        detectQueryString();
    }
    private void detectQueryString(){
        String query;
        //second index is always query parameter
        int firstSlicer = this.originalText.indexOf("query=");
        if(firstSlicer > -1){
            query = this.originalText.substring(firstSlicer+6);
            int secondSlicer = query.indexOf("&");
            query = query.substring(0,secondSlicer);
            this.queryString = query;
        } else {
            this.queryString = "";
        }


//        this.queryString = this.originalText.split("query=|&")[1];
//        this.originalText.indexOf("query=")
    }

    public String[] getText() {
        return text;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public String[] getQueryString() {
        return queryString.split("[+]");
    }

    public String printTokens(){
        return Arrays.toString(this.text);
    }
}
