package controller;

import database.ApplicationsDAO;
import database.JobDAO;
import java.awt.event.*;
import java.util.List;
import java.util.Map;
import javax.swing.*;
import model.Job;
import model.User;
import view.JobSeekerDashboardView;

public class JobSeekerDashboardController {
    private JobSeekerDashboardView view;
    private User user;

    public JobSeekerDashboardController(User user, List<Job> jobs) {
        this.user = user;

        // Load jobs asynchronously
        new Thread(() -> {
            try {
                Thread.sleep(500); // Simulated loading delay

                SwingUtilities.invokeLater(() -> {
                    view = new JobSeekerDashboardView(user.getName(), jobs);
                    addListeners();
                    view.setVisible(true);
                });

                // Start background job refresh
                startPeriodicJobRefresh();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void addListeners() {
        this.view.getViewProfileButton().addActionListener(new ViewProfileListener());
        this.view.getSearchJobsButton().addActionListener(new SearchJobsListener());
        setApplyButtonListeners(view.getApplyButtonsMap());
    }

    // THREAD: Periodically refresh job listings
    private void startPeriodicJobRefresh() {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(10000); // Refresh every 10 seconds

                    List<Job> latestJobs = JobDAO.getAllJobs(); // Fetch updated jobs

                    SwingUtilities.invokeLater(() -> {
                        view.setJobList(latestJobs);
                        setApplyButtonListeners(view.getApplyButtonsMap());
                        System.out.println("Job list updated.");
                    });

                } catch (Exception e) {
                    System.out.println("Error during periodic refresh: " + e.getMessage());
                }
            }
        }).start();
    }

    private void setApplyButtonListeners(Map<JButton, Job> applyButtonsMap) {
        for (Map.Entry<JButton, Job> entry : applyButtonsMap.entrySet()) {
            JButton button = entry.getKey();
            Job job = entry.getValue();

            button.addActionListener(e -> {
                int jobId = job.getJobId();
                boolean success = ApplicationsDAO.applyToJob(user.getUserId(), jobId, user.getResumeLink());
                if (success) {
                    button.setText("Applied");
                    button.setEnabled(false);
                    JOptionPane.showMessageDialog(view,
                            "You have successfully applied to \"" + job.getTitle() + "\" job.",
                            "Application Successful",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(view,
                            "You have already applied to this job.",
                            "Already Applied",
                            JOptionPane.WARNING_MESSAGE);
                }
            });
        }
    }

    private class ViewProfileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new UserProfileController(user);
            view.dispose();
        }
    }

    private class SearchJobsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new JobSearchController(user);
        }
    }
}
