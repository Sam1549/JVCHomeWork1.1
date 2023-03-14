package Lesson1.HomeWork2;

class Worker {
    private OnTaskErrorListener errorCallback;
    private OnTaskDoneListener callback;


    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback ) {
        this.callback = callback;
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
}
