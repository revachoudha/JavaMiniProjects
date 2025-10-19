import java.util.*;

public class Melody {
    private Queue<Note> notes;

    public Melody(Queue<Note> song) {
        notes = new LinkedList<>();
        for (Note n : song) {
            notes.offer(n);
        }
    }

    public double getTotalDuration() {
        Queue<Note> temp = new LinkedList<>(notes);
        double total = 0;
        boolean inRepeat = false;
        double repeatSection = 0;

        while (!temp.isEmpty()) {
            Note n = temp.poll();
            total += n.getDuration();

            if (n.isRepeat()) {
                if (!inRepeat) {
                    inRepeat = true;
                    repeatSection += n.getDuration();
                } else {
                    inRepeat = false;
                    total += repeatSection;
                    repeatSection = 0;
                }
            } else if (inRepeat) {
                repeatSection += n.getDuration();
            }
        }

        return total;
    }

    public void changeTempo(double tempo) {
        Queue<Note> temp = new LinkedList<>();
        while (!notes.isEmpty()) {
            Note n = notes.poll();
            n.setDuration(n.getDuration() / tempo);
            temp.offer(n);
        }
        notes = temp;
    }

    public String toString() {
        Queue<Note> temp = new LinkedList<>(notes);
        StringBuilder sb = new StringBuilder();

        while (!temp.isEmpty()) {
            sb.append(temp.poll().toString()).append("\n");
        }
        return sb.toString();
    }

    public void reverse() {
        Stack<Note> stack = new Stack<>();
        while (!notes.isEmpty()) {
            stack.push(notes.poll());
        }
        while (!stack.isEmpty()) {
            notes.offer(stack.pop());
        }
    }

    public void append(Melody other) {
        Queue<Note> temp = new LinkedList<>(other.getNotes());
        while (!temp.isEmpty()) {
            notes.offer(temp.poll());
        }
    }

    public void play() {
        Queue<Note> temp = new LinkedList<>();
        Queue<Note> repeatSection = new LinkedList<>();
        boolean inRepeat = false;

        while (!notes.isEmpty()) {
            Note n = notes.poll();
            n.play();
            temp.offer(n);

            if (n.isRepeat()) {
                if (!inRepeat) {
                    inRepeat = true;
                    repeatSection.offer(n);
                } else {
                    repeatSection.offer(n);
                    // Play repeat section again
                    for (Note note : repeatSection) {
                        note.play();
                    }
                    repeatSection.clear();
                    inRepeat = false;
                }
            } else if (inRepeat) {
                repeatSection.offer(n);
            }
        }
        notes = temp;
    }

    public Queue<Note> getNotes() {
        return new LinkedList<>(notes);
    }
}