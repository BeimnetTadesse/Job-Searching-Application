package model;

public class Job {
    private int jobId;
    private String title;
    private String description;
    private String employerName;

    public Job(int jobId, String title, String description, String employerName) {
        this.jobId = jobId;
        this.title = title;
        this.description = description;
        this.employerName = employerName;
    }

    public Job() {}

    public int getJobId() {
        return jobId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) { 
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {  
        this.description = description;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {  
        this.employerName = employerName;
    }
    public void setPostedBy(String employerName) {
        this.employerName = employerName;
    }
}
