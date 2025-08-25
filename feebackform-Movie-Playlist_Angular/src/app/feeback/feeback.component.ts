import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-feeback',
  standalone: true,
  imports: [ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatCardModule, NgIf],
  templateUrl: './feeback.component.html',
  styleUrl: './feeback.component.css'
})
export class FeebackComponent {
  feedbackForm: FormGroup;
  showThankYou = false;

  constructor(private fb: FormBuilder) {
    this.feedbackForm = this.fb.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      subject: ['', [Validators.required, Validators.maxLength(40)]],
      comments: ['', [Validators.required, Validators.maxLength(350)]]
    });

    this.feedbackForm.valueChanges.subscribe(() => {
      // Only hide message if the form is not pristine and thank you is showing
      if (this.showThankYou && !this.feedbackForm.pristine) {
        this.showThankYou = false;
      }
    });
  }

  get f() { return this.feedbackForm.controls; }

  onSubmit() {
  if (this.feedbackForm.valid) {
    console.log('Current form values:', this.feedbackForm.value);
    this.showThankYou = true;
    this.feedbackForm.reset();

    // Mark all controls as pristine & untouched to prevent errors showing immediately
    Object.values(this.feedbackForm.controls).forEach(control => {
      control.markAsPristine();
      control.markAsUntouched();
    });
  }
}

}



