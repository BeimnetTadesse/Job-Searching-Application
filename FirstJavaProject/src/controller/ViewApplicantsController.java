package controller;

import database.ApplicationsDAO;
import database.JobDAO;
import model.Job;
import model.User;
import view.ApplicantsListView;

import java.util.List;

public class ViewApplicantsController {
    private User employer;

    public ViewApplicantsController(User employer, Job job) {
        this.employer = employer;

        // Get the applicants for the given job
        List<User> applicants = ApplicationsDAO.getApplicantsForJob(job.getJobId());

        // Create the view
        new ApplicantsListView(applicants, job.getTitle(), () -> {
            List<Job> postedJobs = JobDAO.getJobsPostedByEmployer(employer.getUserId());
            new EmployerDashboardController(employer, postedJobs);
        });
    }
}
