package com.cbfacademy.restapiexercise.ious;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

@Service
public class IOUService {

    private final IOURepository iouRepository;

    public IOUService( IOURepository iouRepository) {
        this.iouRepository = iouRepository;
    }

    public List<IOU> getAllIOUs(){
        return this.iouRepository.findAll();
    }

    public IOU getIOU(UUID id) throws NoSuchElementException{
        return this.iouRepository.findById(id).orElseThrow();
    }

    public IOU createIOU(IOU iou) throws IllegalArgumentException, OptimisticLockingFailureException {
        return this.iouRepository.save(iou);
    }

    public IOU update(UUID id, IOU updatedIOU) throws NoSuchElementException{
        IOU existingIOU = getIOU(id);
        existingIOU.setBorrower(updatedIOU.getBorrower());
        existingIOU.setLender(updatedIOU.getLender());
        existingIOU.setAmount(updatedIOU.getAmount());
        existingIOU.setDateTime(updatedIOU.getDateTime());
        return this.iouRepository.save(existingIOU);
    }

    public void deleteIOU(UUID id){
        this.iouRepository.delete(getIOU(id));
    }
    
} // end main
