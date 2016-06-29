package fd;

/**
 * Exception thrown by the instant reload runtime when something preventing the byte code enhanced
 * code to function properly. This is a generic error that something went wrong in the instant
 * reload runtime and it should be considered a implementation bug.
 *
 * For instance, this can be generated when trying to invoke a super method that the instant runtime
 * cannot find in the generated $super method.
 */
public class InstantReloadException extends Exception {
    public InstantReloadException(String s) {
        super(s);
    }
}