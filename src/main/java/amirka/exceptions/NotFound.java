package amirka.exceptions;

import java.util.UUID;

public class NotFound extends RuntimeException {
    public NotFound(UUID id) {
        super("Using the id " + id + "nothing could be found!");
    }
}