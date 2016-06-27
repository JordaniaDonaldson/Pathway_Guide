package fd;


public interface IncrementalChange {

    IncrementalChange $change = null;
    Object access$dispatch(String id, Object... args);
}