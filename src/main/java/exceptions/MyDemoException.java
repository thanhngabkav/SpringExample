package exceptions;

/**
 * Created by THANH NGA on 6/29/2017.
 */
public class MyDemoException extends Exception{
    private String exceptionContent;

    public MyDemoException(String exceptionContent) {
        this.exceptionContent = exceptionContent;
    }

    public MyDemoException() {
    }

    public String getExceptionContent() {
        return exceptionContent;
    }

    public void setExceptionContent(String exceptionContent) {
        this.exceptionContent = exceptionContent;
    }
}
