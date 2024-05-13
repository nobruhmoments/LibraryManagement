package com.sals.library;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryGUI extends JFrame {

    private BookBrowser bookBrowser;
    private JPanel catalogPanel;

    public LibraryGUI(BookBrowser bookBrowser) {
        this.bookBrowser = bookBrowser;

        setTitle("Library Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Initialize the main panel
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Create a scroll pane to hold the catalog panel
        JScrollPane scrollPane = new JScrollPane();
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Create the catalog panel within the scroll pane
        catalogPanel = new JPanel();
        catalogPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 20));
        scrollPane.setViewportView(catalogPanel);

        // Adjust scroll speed
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setUnitIncrement(20); // Set the scroll increment (adjust as needed)

        // Button to add a new book
        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewBook();
            }
        });
        mainPanel.add(addButton, BorderLayout.NORTH);

        setContentPane(mainPanel);
    }

    private void addNewBook() {
        // Simulate adding a new book to the BookBrowser
        Book newBook = new Book("New Book", "Unknown Author");
        bookBrowser.addBook(newBook);

        // Display the updated catalog
        refreshCatalog();
    }

    private void refreshCatalog() {
        // Clear the catalog panel
        catalogPanel.removeAll();

        // Retrieve the catalog from BookBrowser and display each book
        Book[] catalog = bookBrowser.getCatalog();
        for (Book book : catalog) {
            // Create a panel to represent each book
            JPanel bookPanel = createBookPanel(book);
            catalogPanel.add(bookPanel);
        }

        // Set preferred size based on the number of books to control layout
        int rowCount = (catalog.length + 3) / 4; // Assuming 4 books per row
        int panelWidth = catalogPanel.getWidth();
        int panelHeight = rowCount * (200 + 20); // Book panel height + vertical gap
        catalogPanel.setPreferredSize(new Dimension(panelWidth, panelHeight));

        // Refresh the display
        catalogPanel.revalidate();
        catalogPanel.repaint();
    }

    private JPanel createBookPanel(Book book) {
        JPanel bookPanel = new JPanel();
        bookPanel.setLayout(new BorderLayout());
        bookPanel.setPreferredSize(new Dimension(200, 200));
        bookPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Display book information
        JLabel titleLabel = new JLabel(book.getTitle());
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bookPanel.add(titleLabel, BorderLayout.NORTH);

        // Create edit button
        JButton editButton = new JButton("Edit");
        editButton.setPreferredSize(new Dimension(80, 30)); // Set custom size for edit button
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open an edit dialog to modify book details
                editBookDetails(book);
            }
        });

        // Panel to hold the edit button in the center
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonPanel.add(editButton, gbc);

        bookPanel.add(buttonPanel, BorderLayout.CENTER);

        return bookPanel;
    }

    private void editBookDetails(Book book) {
        // Create input fields for book details
        JTextField titleField = new JTextField(book.getTitle());
        JTextField authorField = new JTextField(book.getAuthor());
        JTextField dateField = new JTextField(book.getDate()); // Assuming date is a string
        JTextField descriptionField = new JTextField(book.getDescription());
        JCheckBox availableCheckbox = new JCheckBox("Available", book.isAvailable());

        // Create a panel to hold the input fields
        JPanel editPanel = new JPanel(new GridLayout(0, 2));
        editPanel.add(new JLabel("Title:"));
        editPanel.add(titleField);
        editPanel.add(new JLabel("Author:"));
        editPanel.add(authorField);
        editPanel.add(new JLabel("Date:"));
        editPanel.add(dateField);
        editPanel.add(new JLabel("Description:"));
        editPanel.add(descriptionField);
        editPanel.add(availableCheckbox);

        // Show input dialog
        int result = JOptionPane.showConfirmDialog(
                this, editPanel, "Edit Book Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            // Update book details based on user input
            book.setTitle(titleField.getText());
            book.setAuthor(authorField.getText());
            book.setDate(dateField.getText()); // Update date as string
            book.setDescription(descriptionField.getText());
            book.setAvailable(availableCheckbox.isSelected());

            // Update book in BookBrowser (you'll need to implement this method)
            bookBrowser.updateBook(book);

            // Refresh catalog display
            refreshCatalog();
        }
    }

    public static void main(String[] args) {
        // Create a BookBrowser instance and initialize LibraryGUI
        BookBrowser bookBrowser = new BookBrowser();
        LibraryGUI libraryGUI = new LibraryGUI(bookBrowser);

        // Display the GUI
        libraryGUI.setVisible(true);

        // Initial display of the catalog
        libraryGUI.refreshCatalog();
    }
}