import { Component } from '@angular/core';
import { Book } from '../book';
import { BookService } from '../book.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-book',
  templateUrl: './create-book.component.html',
  styleUrls: ['./create-book.component.css']
})
export class CreateBookComponent {

  book: Book = new Book();
  submitted: Boolean = false;

  constructor(private bookService: BookService, private router: Router) { }
  
  ngOnInit() {}

  newEmployee(): void {
    this.submitted = false;
    this.book = new Book();
  }

  save() {
    this.bookService
      .createBook(this.book)
      .subscribe(data => {
        console.log(data)
        this.book = new Book();
        this.gotoList();
      },
      error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(['/books']);
  }
}
