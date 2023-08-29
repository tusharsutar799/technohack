package timerStopwatch.in.code;


	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	public class Main  extends JFrame {
	    private JLabel timerLabel;
	    private JButton startButton;
	    private JButton resetButton;
	    private Timer countdownTimer;
	    private long startTime;
	    private long elapsedTime;

	    public Main() {
	        setTitle("Timer and Stopwatch");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLayout(new FlowLayout());

	        timerLabel = new JLabel("00:00:00");
	        timerLabel.setFont(new Font("Arial", Font.BOLD, 40));
	        add(timerLabel);

	        startButton = new JButton("Start");
	        add(startButton);

	        resetButton = new JButton("Reset");
	        add(resetButton);

	        countdownTimer = new Timer(1000, new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                updateTimer();
	            }
	        });

	        startButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                if (!countdownTimer.isRunning()) {
	                    startTimer();
	                    startButton.setText("Pause");
	                } else {
	                    pauseTimer();
	                    startButton.setText("Resume");
	                }
	            }
	        });

	        resetButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                resetTimer();
	                startButton.setText("Start");
	            }
	        });

	        pack();
	        setLocationRelativeTo(null);
	    }

	    private void startTimer() {
	        if (!countdownTimer.isRunning()) {
	            startTime = System.currentTimeMillis() - elapsedTime;
	            countdownTimer.start();
	        }
	    }

	    private void pauseTimer() {
	        if (countdownTimer.isRunning()) {
	            countdownTimer.stop();
	            elapsedTime = System.currentTimeMillis() - startTime;
	        }
	    }

	    private void resetTimer() {
	        countdownTimer.stop();
	        timerLabel.setText("00:00:00");
	        elapsedTime = 0;
	    }

	    private void updateTimer() {
	        long currentTime = System.currentTimeMillis();
	        long deltaTime = currentTime - startTime + elapsedTime;
	        int seconds = (int) (deltaTime / 1000);
	        int minutes = seconds / 60;
	        int hours = minutes / 60;

	        seconds %= 60;
	        minutes %= 60;

	        String timeText = String.format("%02d:%02d:%02d", hours, minutes, seconds);
	        timerLabel.setText(timeText);
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new Main().setVisible(true);
	            }
	        });
	    }
	}

	
	

