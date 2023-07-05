import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from '../book';
import { BookService } from '../book.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent {
  books!: Observable<Book[]>;

  constructor(private bookService: BookService, private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.books = this.bookService.getBooksList();
  }

  deleteBook(id: number) {
    this.bookService.deleteBook(id)
    .subscribe(
      data => {
        console.log(data);
        this.reloadData();
      },
      error => console.log(error));
  }

  updateBook(id: number) {
    this.router.navigate(['update', id]);
  }
}
