package Lesson1.HomeWork2;


public class Main {
    public static void main(String[] args) {
        Worker.OnTaskDoneListener listener = System.out::println;


        Worker worker = new Worker(listener);
        worker.start();
    }
}

class Worker {
    private OnTaskErrorListener errorCallback;
    private OnTaskDoneListener callback;


    public Worker(OnTaskDoneListener callback) {
        this.callback = callback;
    }

    public Worker(OnTaskErrorListener errorCallback) {
        this.errorCallback = errorCallback;
    }


    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i == 33) {
                errorCallback = System.out::println;
                errorCallback.onError("ERROR");

            } else {
                callback.onDone("Task " + i + " is done");
            }

        }
    }

    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }

    @FunctionalInterface
    public interface OnTaskErrorListener {
        void onError(String result);
    }
}

