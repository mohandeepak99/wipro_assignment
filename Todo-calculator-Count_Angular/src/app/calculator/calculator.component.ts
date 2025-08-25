import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-calculator',
  imports: [FormsModule],
  templateUrl: './calculator.component.html',
  styleUrl: './calculator.component.css'
})
export class CalculatorComponent {
  num1: number = 0;
  num2: number = 0;
  result: number = 0;

  addNumbers() {
    this.result = Number(this.num1) + Number(this.num2);
  }

  subtractNumbers() {
    this.result = Number(this.num1) - Number(this.num2);
  }

  multiplyNumbers() {
    this.result = Number(this.num1) * Number(this.num2);
  }

  divideNumbers() {
    if (Number(this.num2) !== 0) {
      this.result = Number(this.num1) / Number(this.num2);
    } else {
      this.result = NaN; // Or show a custom error message in the template
    }
  }




}
