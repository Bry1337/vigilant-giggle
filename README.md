
# Android-Kotlin Navigation Architecture Component Demo
This project is a proof of concept that uses [Navigation Architecture Component](https://developer.android.com/topic/libraries/architecture/navigation/), this app is a simple Notes app without domain knowledge needed to understand the purpose of this app.

## Functionality included

 1. List notes
 2. View Single note
 3. Edit a note
 4. Delete a note
 5. Deep link to a note
 6. Connecting ``` Nav Drawer``` with your navigation graph
 7. Configuring type-safe arguments between navigation components (between Fragments in this project)

## Design Pattern
MVVM (Model-View-ViewModel) is used to make the architecture cleaner, more readable and maintanable. Notes are stored and managed in memory within the domain layer (this sample is about Navigation and not full-blown [Clean Architecture](https://github.com/Bry1337/fuzzy-computing-machine)

### Postscript
This project is built following some article and samples provided by Google and with help of other Jetpack libraries such as [ViewModel and LiveData](https://developer.android.com/topic/libraries/architecture/viewmodel)

# LICENSE
MIT Liecense
```
Copyright (c) 2019 Edward Bryan Abergas

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
