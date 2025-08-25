import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { NavbarComponent } from './navbar/navbar.component';
import { CalculatorComponent } from "./calculator/calculator.component";
import { ToDoComponent } from './to-do/to-do.component';



@Component({
  selector: 'app-root',
  imports: [RouterOutlet, FormsModule, NavbarComponent, CalculatorComponent, ToDoComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Hello_world';
  xyz:boolean = true;
  isHighlighted:boolean = true;

  message:string="Angular is awesome!"

  isDisabledxyz:boolean = false

  username:string="";

  count:number = 0;

  increment() {
    this.count++;
  }
  decrement() {
    this.count--;
  }
  typedName="";
  showname(value: string) {
    this.typedName = value;
  }
}
