package service;

import domain.*;
import exceptions.CDNotFoundException;
import exceptions.RecordNotFoundException;

import java.util.*;

public class MusicService {
    private Map<Integer, CD> cds;
    private Map<Integer, Record> records;

    public MusicService() {
        this.cds = new HashMap<>();
        this.records = new HashMap<>();
    }

    //add a CD to the collection
    public void addCD(CD cd) {
        if (this.cds.containsKey(cd.getId())) {
            throw new IllegalArgumentException("CD with ID " + cd.getId() + " already exists in collection");
        }
        this.cds.put(cd.getId(), cd);
    }

    //add a record to the collection
    public void addRecord(Record record) {
        if (this.records.containsKey(record.getId())) {
            throw new IllegalArgumentException("Record with ID " + record.getId() + " already exists in collection");
        }
        this.records.put(record.getId(), record);
    }

    //remove CD from the collection
    public void removeCD(int cdId) {
        if (!this.cds.containsKey(cdId)) {
            throw new CDNotFoundException("CD with ID " + cdId + " not found in collection");
        }
        this.cds.remove(cdId);
    }

    //remove record from the collection
    public void removeRecord(int recordId) {
        if (!this.records.containsKey(recordId)) {
            throw new RecordNotFoundException(recordId);
        }
        this.records.remove(recordId);
    }

    //searches CDs in collection
    public List<CD> searchCDs(String query) {
        List<CD> results = new ArrayList<>();
        for (CD cd : this.cds.values()) {
            if (cd.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    cd.getArtist().getName().toLowerCase().contains(query.toLowerCase())) {
                results.add(cd);
            }
        }
        return results;
    }

    //searches records in collection
    public List<Record> searchRecords(String query) {
        List<Record> results = new ArrayList<>();
        for (Record record : this.records.values()) {
            if (record.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    record.getArtist().getName().toLowerCase().contains(query.toLowerCase())) {
                results.add(record);
            }
        }
        return results;
    }

    //returns all CDs in the collection
    public List<CD> getAllCDs() {
        return new ArrayList<>(this.cds.values());
    }

    //returns all records in the collection
    public List<Record> getAllRecords() {
        return new ArrayList<>(this.records.values());
    }

    //returns CD by id
    public CD getCDById(int cdId) throws CDNotFoundException {
        if (!this.cds.containsKey(cdId)) {
            throw new CDNotFoundException("CD with ID " + cdId + " not found in collection");
        }
        return this.cds.get(cdId);
    }

    //returns record by id
    public Record getRecordById(int recordId) throws RecordNotFoundException {
        if (!this.records.containsKey(recordId)) {
            throw new RecordNotFoundException(recordId);
        }
        return this.records.get(recordId);
    }

    //returns CDs by artist
    public List<CD> getCDsByArtist(Author artist) {
        List<CD> results = new ArrayList<>();
        for (CD cd : this.cds.values()) {
            if (cd.getArtist().equals(artist)) {
                results.add(cd);
            }
        }
        return results;
    }

    public void printCD(int id) {
        CD cd = getCDById(id);
        System.out.println(cd.toString());
    }
    public void printRecord(int id) {
        Record record = getRecordById(id);
        System.out.println(record.toString());
    }

}