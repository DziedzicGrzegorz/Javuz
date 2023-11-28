package UZ.Grzesiek.Lab6_P.StatusOfMachine;

public enum StatusOfMachine {    OK(200),
    OFF(1),
    STOPPED(2),
    ERROR(500),
    WORKING(409),
    READY(200),
    FINISHED(200),
    SERVICE_NEEDED(423);

    private final int statusCode;
    StatusOfMachine(int statusCode) {
        this.statusCode = statusCode;
    }
    public int getStatusCode() {
        return statusCode;
    }



}
