package se.tobias.gymbuddy;

public class TrainingMax {
    private int BenchPressMax;
    private int SquatMax;
    private int DeadliftMax;
    private int OverheadPressMax;

    public TrainingMax(int benchPressMax, int squatMax, int deadliftMax, int overheadPressMax) {
        BenchPressMax = benchPressMax;
        SquatMax = squatMax;
        DeadliftMax = deadliftMax;
        OverheadPressMax = overheadPressMax;
    }

    public int getBenchPressMax() {
        return BenchPressMax;
    }

    public void setBenchPressMax(int benchPressMax) {
        BenchPressMax = benchPressMax;
    }

    public int getSquatMax() {
        return SquatMax;
    }

    public void setSquatMax(int squatMax) {
        SquatMax = squatMax;
    }

    public int getDeadliftMax() {
        return DeadliftMax;
    }

    public void setDeadliftMax(int deadliftMax) {
        DeadliftMax = deadliftMax;
    }

    public int getOverheadPressMax() {
        return OverheadPressMax;
    }

    public void setOverheadPressMax(int overheadPressMax) {
        OverheadPressMax = overheadPressMax;
    }
}
