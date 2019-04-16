package net.unibave.objetivo_meta.controller;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;

import net.unibave.objetivo_meta.model.Task;
import net.unibave.objetivo_meta.model.TaskLocalDatabaseRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class TaskController {

    TaskLocalDatabaseRepository repository;
    public TaskController(Context context) {
        repository = new TaskLocalDatabaseRepository(context);
    }

    public List<Task> findAll() {
        return repository.findAll();
    }

    @TargetApi(Build.VERSION_CODES.O)
    public void create(String name, String dataTarefa) {
        String id = UUID.randomUUID().toString();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Task task = new Task();
        task.setId(id);
        task.setName(name);
        try {
            task.setDataTarefa(sdf.parse(dataTarefa));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        task.setCreatedAt(new Date());
        task.setDone(false);

        validateName(task);

        repository.create(task);
    }

    public void edit(Task task) {
        validateName(task);
        repository.edit(task);
    }

    private void validateName(Task task) {
        if (task.getName().isEmpty() || task.getName().length() > 40) {
            throw new RuntimeException("Invalid task name!");
        }
    }

    public void delete(Task task) {
        repository.delete(task);
    }

    public void done(Task task) {
        task.setDone(true);
        edit(task);
    }

    public void reset(Task task) {
        task.setDone(false);
        edit(task);
    }
}

