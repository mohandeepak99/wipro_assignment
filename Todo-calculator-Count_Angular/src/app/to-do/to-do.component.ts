import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-to-do',
  imports: [FormsModule,CommonModule],
  templateUrl: './to-do.component.html',
  styleUrl: './to-do.component.css'
})
export class ToDoComponent {

  // Holds the value of the user’s current input
  newTask: string = '';
  // Array to store all tasks
  tasks: string[] = [];

  // Add a new task if the input is not empty or just whitespace
  addTask() {
    const task = this.newTask.trim();
    if (task.length > 0) {
      this.tasks.push(task);
      this.newTask = '';
    }
  }

  // Remove task by index
  removeTask(index: number) {
    this.tasks.splice(index, 1);
  }

}
