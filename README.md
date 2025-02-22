Notepad - A Simple Java Text Editor

This is a simple Notepad application built using Java's Swing framework. It allows you to create, edit, save, and open .txt files. The application offers basic text editing functionalities such as copy, cut, paste, and print, with keyboard shortcuts for easy usage.

Features

File Operations- 
New (Ctrl+N): Start a new document.
Open (Ctrl+O): Open an existing .txt file.
Save (Ctrl+S): Save the current text as a .txt file.
Print (Ctrl+P): Print the current document.

Edit Operations- 
Copy (Ctrl+C): Copy selected text.
Cut (Ctrl+X): Cut selected text.
Paste (Ctrl+V): Paste text from the clipboard.

Additional Features- 
Help: Shows a list of keyboard shortcuts.
About: Displays information about the application (developer, version, etc.).
Info: Displays additional information about the application (via another window).

How to Run
Clone or download the source code.
Compile and run the Notepad.java file using your preferred IDE or the terminal.
Once the application is launched, you can start creating and editing text documents.
Or Eles Directly Use The Executable File (.exe) Provided In The Repo

Keyboard Shortcuts
New: Ctrl+N
Open: Ctrl+O
Save: Ctrl+S
Print: Ctrl+P
Copy: Ctrl+C
Cut: Ctrl+X
Paste: Ctrl+V
Help: Ctrl+H
About: Ctrl+I
Exit: Esc

Code Walkthrough

The program uses Swing components to build the GUI. Here's a brief explanation of the key parts of the code:

1. JMenuBar and Menus
The menu bar contains three menus: File, Edit, and Help.
File: Includes options like New, Open, Save, Print, and Exit.
Edit: Includes text-editing options like Copy, Cut, and Paste.
Help: Provides Help and About information.

3. Text Area
The JTextArea is used for editing the text. It is wrapped inside a JScrollPane to allow scrolling when the content exceeds the visible area.
The text area supports line wrapping and word wrapping for easier readability.

5. File Operations
Open: Uses JFileChooser to select and open .txt files.
Save: Saves the current text into a .txt file using BufferedWriter.
Print: Prints the current text using the print() method from JTextArea.

7. Action Listeners
Each menu item is connected to an ActionListener that triggers actions like opening a file, saving text, copying, cutting, etc.
Shortcuts like Ctrl+S or Ctrl+C are assigned to respective menu items.

9. Error Handling
The application uses JOptionPane to display error messages for failed file read/write operations or printing errors.
