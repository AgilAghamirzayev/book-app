export class Book {
  id: number;
  title: string;
  author: string;
  coverPhotoUrl: string;
  isbnNumber: number;
  price: number;
  language: string;

  constructor(id: number, title: string, author: string, coverPhotoUrl: string, isbnNumber: number, price: number, language: string) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.coverPhotoUrl = coverPhotoUrl;
    this.isbnNumber = isbnNumber;
    this.price = price;
    this.language = language;
  }

}
