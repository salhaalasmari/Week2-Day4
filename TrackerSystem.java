package com.example.week2day2.controller;


import com.example.week2day2.ApiResponse;
import com.example.week2day2.Model.Customers;
import com.example.week2day2.Model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TrackerSystem {

    ArrayList<Task> MyTask = new ArrayList<>();



    //Get all the Task
    @GetMapping("/Task")
    public ArrayList<Task> getTask(){
        return MyTask;
    }
    //Add new customers
    @PostMapping("/Task")
    public ApiResponse addTask(@RequestBody Task myTask){
      MyTask.add(myTask);
        return new ApiResponse("Add new Tasks .. Thank you");
    }
    //Update Tasks
    @PutMapping("/Task/{index}")
    public ApiResponse updatTask(@PathVariable int index,@RequestBody Task myTask){
        MyTask.set(index,myTask);
        return new ApiResponse("Update Tasks successfully .. ");
    }
    @DeleteMapping("/Task/{index}")
    public ApiResponse deleteTask(@PathVariable int index){
        MyTask.remove(index);
        return new ApiResponse("Delete Tasks successfully ..");
    }

    /// all above is CRUD :- CREATE , RETURN , UPDATE , DELETE

    // now new method
    // Search for a task by given title
    @GetMapping("/Task/Search")
    public ApiResponse search(@RequestBody String title){
        for (int i = 0; i < MyTask.size(); i++) {
            if(MyTask.get(i).getTitle()==title){
                return new ApiResponse(MyTask.get(i).toString());
            }
        }
        return new ApiResponse("Wrong title");
    }
// Change the task status as done or not done
    @PutMapping("/Task/change/{index}")
    public ApiResponse change(@PathVariable Integer index,@RequestBody String status){
        MyTask.get(index).setStatus(status);
        return new ApiResponse("status has been update");
    }


}
