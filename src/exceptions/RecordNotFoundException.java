package exceptions;



    public class RecordNotFoundException extends RuntimeException {
        public RecordNotFoundException(int recordId) {
            super("Record with ID " + recordId + " not found in collection");
        }
    }

