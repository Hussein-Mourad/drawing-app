/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.DrawingPanelController;
import Controllers.StateManager;

/**
 *
 * @author hussein
 */
public class MainFrame extends javax.swing.JFrame {

    DrawingPanelController controller;
    DrawingPanel drawPanel;

    /**
     * Creates new form NewJFrame1
     */
    public MainFrame() {
        drawPanel = new DrawingPanel();
        initComponents();
        controller = DrawingPanelController.getInstance(drawPanel);
        drawingPanel.add(drawPanel);
        currentColor.add(controller.getColorBox());
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rightClickMenu = new javax.swing.JPopupMenu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        background = new javax.swing.JPanel();
        drawingPanel = new javax.swing.JPanel();
        topBar = new javax.swing.JToolBar();
        filler9 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 5), new java.awt.Dimension(5, 5), new java.awt.Dimension(5, 5));
        undoButton = new javax.swing.JButton();
        redoButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 5), new java.awt.Dimension(5, 5), new java.awt.Dimension(5, 5));
        lineStrokeLabel = new javax.swing.JLabel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 5), new java.awt.Dimension(5, 5), new java.awt.Dimension(5, 5));
        lineStrokeMenu = new javax.swing.JComboBox<>();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 5), new java.awt.Dimension(5, 5), new java.awt.Dimension(5, 5));
        brushStrokeLabel = new javax.swing.JLabel();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 5), new java.awt.Dimension(5, 5), new java.awt.Dimension(5, 5));
        brushStrokeMenu = new javax.swing.JComboBox<>();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 5), new java.awt.Dimension(5, 5), new java.awt.Dimension(5, 5));
        brushStrokeLabel1 = new javax.swing.JLabel();
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 5), new java.awt.Dimension(5, 5), new java.awt.Dimension(5, 5));
        eraserSizeMenu = new javax.swing.JComboBox<>();
        filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 5), new java.awt.Dimension(5, 5), new java.awt.Dimension(5, 5));
        colorPickerButton = new javax.swing.JButton();
        filler10 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 5), new java.awt.Dimension(5, 5), new java.awt.Dimension(5, 5));
        currentColor = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        sideBar = new javax.swing.JToolBar();
        mousePointerButton = new javax.swing.JToggleButton();
        pencilButton = new javax.swing.JToggleButton();
        brushButton = new javax.swing.JToggleButton();
        eraserButton = new javax.swing.JToggleButton();
        lineButton = new javax.swing.JToggleButton();
        rectangleButton = new javax.swing.JToggleButton();
        squareButton = new javax.swing.JToggleButton();
        circleButton = new javax.swing.JToggleButton();
        triangleButton = new javax.swing.JToggleButton();
        ellispeButton = new javax.swing.JToggleButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        moveButton = new javax.swing.JToggleButton();
        fillButton = new javax.swing.JToggleButton();
        deleteButton = new javax.swing.JToggleButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        clearButton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        newProjectMenuItem = new javax.swing.JMenuItem();
        saveProjectMenuItem = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        undoButtonMenu = new javax.swing.JMenuItem();
        redoButtonMenu = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Paint App");
        setMinimumSize(new java.awt.Dimension(947, 537));
        setSize(new java.awt.Dimension(947, 537));

        drawingPanel.setForeground(new java.awt.Color(255, 0, 255));
        drawingPanel.setLayout(new java.awt.BorderLayout());

        topBar.setFloatable(false);
        topBar.add(filler9);

        undoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/outline_undo_black_24dp.png"))); // NOI18N
        undoButton.setToolTipText("undo");
        undoButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        undoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoButtonActionPerformed(evt);
            }
        });
        topBar.add(undoButton);

        redoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/outline_redo_black_24dp.png"))); // NOI18N
        redoButton.setToolTipText("redo");
        redoButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        redoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redoButtonActionPerformed(evt);
            }
        });
        topBar.add(redoButton);
        topBar.add(jSeparator2);
        topBar.add(filler2);

        lineStrokeLabel.setText("Line Stroke");
        topBar.add(lineStrokeLabel);
        topBar.add(filler3);

        lineStrokeMenu.setEditable(true);
        lineStrokeMenu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "12", "14", "16", "18", "20", "22", "24" }));
        lineStrokeMenu.setToolTipText("Line Stroke");
        lineStrokeMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lineStrokeMenu.setMaximumSize(new java.awt.Dimension(100, 25));
        lineStrokeMenu.setMinimumSize(new java.awt.Dimension(100, 25));
        lineStrokeMenu.setPreferredSize(new java.awt.Dimension(100, 25));
        lineStrokeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineStrokeMenuActionPerformed(evt);
            }
        });
        topBar.add(lineStrokeMenu);
        topBar.add(filler5);

        brushStrokeLabel.setText("Brush Stroke");
        topBar.add(brushStrokeLabel);
        topBar.add(filler4);

        brushStrokeMenu.setEditable(true);
        brushStrokeMenu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "12", "14", "16", "18", "20", "22", "24" }));
        brushStrokeMenu.setSelectedIndex(9);
        brushStrokeMenu.setToolTipText("Line Stroke");
        brushStrokeMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        brushStrokeMenu.setMaximumSize(new java.awt.Dimension(100, 25));
        brushStrokeMenu.setMinimumSize(new java.awt.Dimension(100, 25));
        brushStrokeMenu.setPreferredSize(new java.awt.Dimension(100, 25));
        brushStrokeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brushStrokeMenuActionPerformed(evt);
            }
        });
        topBar.add(brushStrokeMenu);
        topBar.add(filler6);

        brushStrokeLabel1.setText("Eraser Size");
        topBar.add(brushStrokeLabel1);
        topBar.add(filler7);

        eraserSizeMenu.setEditable(true);
        eraserSizeMenu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "12", "14", "16", "18", "20", "22", "24" }));
        eraserSizeMenu.setSelectedIndex(9);
        eraserSizeMenu.setToolTipText("Line Stroke");
        eraserSizeMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        eraserSizeMenu.setMaximumSize(new java.awt.Dimension(100, 25));
        eraserSizeMenu.setMinimumSize(new java.awt.Dimension(100, 25));
        eraserSizeMenu.setPreferredSize(new java.awt.Dimension(100, 25));
        eraserSizeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eraserSizeMenuActionPerformed(evt);
            }
        });
        topBar.add(eraserSizeMenu);
        topBar.add(filler8);

        colorPickerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/outline_color_lens_black_24dp.png"))); // NOI18N
        colorPickerButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        colorPickerButton.setFocusable(false);
        colorPickerButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        colorPickerButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        colorPickerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorPickerButtonActionPerformed(evt);
            }
        });
        topBar.add(colorPickerButton);
        topBar.add(filler10);

        currentColor.setBackground(new java.awt.Color(204, 0, 0));
        currentColor.setForeground(new java.awt.Color(0, 0, 0));
        currentColor.setMaximumSize(new java.awt.Dimension(24, 24));
        currentColor.setMinimumSize(new java.awt.Dimension(24, 24));
        currentColor.setPreferredSize(new java.awt.Dimension(24, 24));
        currentColor.setLayout(new java.awt.BorderLayout());
        topBar.add(currentColor);
        topBar.add(filler1);

        sideBar.setBackground(new java.awt.Color(255, 102, 153));
        sideBar.setFloatable(false);
        sideBar.setForeground(new java.awt.Color(102, 255, 102));
        sideBar.setOrientation(javax.swing.SwingConstants.VERTICAL);
        sideBar.setRollover(true);

        buttonGroup1.add(mousePointerButton);
        mousePointerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/mouse-pointer.png"))); // NOI18N
        mousePointerButton.setFocusable(false);
        mousePointerButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mousePointerButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mousePointerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mousePointerButtonActionPerformed(evt);
            }
        });
        sideBar.add(mousePointerButton);

        buttonGroup1.add(pencilButton);
        pencilButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/outline_create_black_24dp.png"))); // NOI18N
        pencilButton.setToolTipText("Pencil");
        pencilButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pencilButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pencilButtonActionPerformed(evt);
            }
        });
        sideBar.add(pencilButton);

        buttonGroup1.add(brushButton);
        brushButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/outline_brush_black_24dp.png"))); // NOI18N
        brushButton.setToolTipText("Brush");
        brushButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        brushButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brushButtonActionPerformed(evt);
            }
        });
        sideBar.add(brushButton);

        buttonGroup1.add(eraserButton);
        eraserButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/outline_eraser_black_24dp.png"))); // NOI18N
        eraserButton.setToolTipText("Etaser");
        eraserButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eraserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eraserButtonActionPerformed(evt);
            }
        });
        sideBar.add(eraserButton);

        buttonGroup1.add(lineButton);
        lineButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/outline_maximize_black_24dp.png.png"))); // NOI18N
        lineButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lineButton.setFocusable(false);
        lineButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lineButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineButtonActionPerformed(evt);
            }
        });
        sideBar.add(lineButton);

        buttonGroup1.add(rectangleButton);
        rectangleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/outline_crop_16_9_black_24dp.png"))); // NOI18N
        rectangleButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rectangleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rectangleButtonActionPerformed(evt);
            }
        });
        sideBar.add(rectangleButton);

        buttonGroup1.add(squareButton);
        squareButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/outline_crop_square_black_24dp.png"))); // NOI18N
        squareButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        squareButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                squareButtonActionPerformed(evt);
            }
        });
        sideBar.add(squareButton);

        buttonGroup1.add(circleButton);
        circleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/outline_circle_black_24dp.png"))); // NOI18N
        circleButton.setToolTipText("");
        circleButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        circleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                circleButtonActionPerformed(evt);
            }
        });
        sideBar.add(circleButton);

        buttonGroup1.add(triangleButton);
        triangleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/outline_change_history_black_24dp.png"))); // NOI18N
        triangleButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        triangleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                triangleButtonActionPerformed(evt);
            }
        });
        sideBar.add(triangleButton);

        buttonGroup1.add(ellispeButton);
        ellispeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/outline_oval_black_24dp.png"))); // NOI18N
        ellispeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ellispeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ellispeButtonActionPerformed(evt);
            }
        });
        sideBar.add(ellispeButton);
        sideBar.add(jSeparator3);

        buttonGroup1.add(moveButton);
        moveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/outline_open_with_black_24dp.png"))); // NOI18N
        moveButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        moveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveButtonActionPerformed(evt);
            }
        });
        sideBar.add(moveButton);

        buttonGroup1.add(fillButton);
        fillButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/outline_format_color_fill_black_24dp.png"))); // NOI18N
        fillButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fillButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillButtonActionPerformed(evt);
            }
        });
        sideBar.add(fillButton);

        buttonGroup1.add(deleteButton);
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/outline_delete_black_24dp.png"))); // NOI18N
        deleteButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        sideBar.add(deleteButton);
        sideBar.add(jSeparator4);

        clearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/outline_clear_all_black_18dp.png"))); // NOI18N
        clearButton.setToolTipText("Clear All");
        clearButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        sideBar.add(clearButton);

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(sideBar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(drawingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(topBar, javax.swing.GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(topBar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(drawingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(sideBar, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 23, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(background, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");

        newProjectMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        newProjectMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/outline_add_black_18dp.png"))); // NOI18N
        newProjectMenuItem.setText("New Project");
        jMenu1.add(newProjectMenuItem);

        saveProjectMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        saveProjectMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/outline_save_black_18dp.png"))); // NOI18N
        saveProjectMenuItem.setText("Save Project");
        jMenu1.add(saveProjectMenuItem);

        menuBar.add(jMenu1);

        jMenu3.setText("Edit");

        undoButtonMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        undoButtonMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/outline_undo_black_18dp.png"))); // NOI18N
        undoButtonMenu.setText("Undo");
        undoButtonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoButtonMenuActionPerformed(evt);
            }
        });
        jMenu3.add(undoButtonMenu);

        redoButtonMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        redoButtonMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/outline_redo_black_18dp.png"))); // NOI18N
        redoButtonMenu.setText("Redo");
        redoButtonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redoButtonMenuActionPerformed(evt);
            }
        });
        jMenu3.add(redoButtonMenu);
        jMenu3.add(jSeparator1);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/outline_content_cut_black_18dp.png"))); // NOI18N
        jMenuItem3.setText("Cut");
        jMenu3.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/outline_content_copy_black_18dp.png"))); // NOI18N
        jMenuItem4.setText("Copy");
        jMenu3.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/outline_content_paste_black_18dp.png"))); // NOI18N
        jMenuItem5.setText("Paste");
        jMenu3.add(jMenuItem5);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/outline_delete_black_18dp.png"))); // NOI18N
        jMenuItem6.setText("Delete");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        menuBar.add(jMenu3);

        jMenu2.setText("Help");

        aboutMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/outline_info_black_18dp.png"))); // NOI18N
        aboutMenuItem.setText("About");
        jMenu2.add(aboutMenuItem);

        menuBar.add(jMenu2);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void redoButtonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoButtonMenuActionPerformed
        StateManager.redo();
    }//GEN-LAST:event_redoButtonMenuActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed

    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void undoButtonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoButtonMenuActionPerformed
        StateManager.undo();
    }//GEN-LAST:event_undoButtonMenuActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        controller.clearShapes();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void undoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoButtonActionPerformed
        StateManager.undo();
    }//GEN-LAST:event_undoButtonActionPerformed

    private void redoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoButtonActionPerformed
        StateManager.redo();
    }//GEN-LAST:event_redoButtonActionPerformed

    private void squareButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_squareButtonActionPerformed
        if (squareButton.isSelected()) {
            controller.setMode(Mode.INSERT_SQUARE);
        } else {
            controller.resetMode();
        }
    }//GEN-LAST:event_squareButtonActionPerformed

    private void pencilButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pencilButtonActionPerformed
        if (pencilButton.isSelected()) {
            controller.setMode(Mode.INSERT_PENCIL);
        } else {
            controller.resetMode();
        }
    }//GEN-LAST:event_pencilButtonActionPerformed

    private void brushButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brushButtonActionPerformed

        if (brushButton.isSelected()) {

            controller.setMode(Mode.INSERT_BRUSH);

        } else {
            controller.resetMode();
        }
    }//GEN-LAST:event_brushButtonActionPerformed

    private void eraserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eraserButtonActionPerformed

        if (eraserButton.isSelected()) {

            controller.setMode(Mode.ERASER);

        } else {
            controller.resetMode();
        }
    }//GEN-LAST:event_eraserButtonActionPerformed

    private void rectangleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rectangleButtonActionPerformed
        if (rectangleButton.isSelected()) {

            controller.setMode(Mode.INSERT_RECTANLE);

        } else {
            controller.resetMode();
        }

    }//GEN-LAST:event_rectangleButtonActionPerformed

    private void eraserSizeMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eraserSizeMenuActionPerformed
        int stroke = Integer.valueOf((String) eraserSizeMenu.getSelectedItem());
        controller.setEraserStroke(stroke);
    }//GEN-LAST:event_eraserSizeMenuActionPerformed

    private void circleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_circleButtonActionPerformed

        controller.setMode(Mode.INSERT_CIRCLE);
    }//GEN-LAST:event_circleButtonActionPerformed

    private void triangleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_triangleButtonActionPerformed

        if (triangleButton.isSelected()) {

            controller.setMode(Mode.INSERT_TRIANGLE);

        } else {
            controller.resetMode();
        }
    }//GEN-LAST:event_triangleButtonActionPerformed

    private void ellispeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ellispeButtonActionPerformed

        controller.setMode(Mode.INSERT_ELLIPSE);
    }//GEN-LAST:event_ellispeButtonActionPerformed

    private void moveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveButtonActionPerformed

        if (moveButton.isSelected()) {

            controller.setMode(Mode.MOVE);

        } else {
            controller.resetMode();
        }
    }//GEN-LAST:event_moveButtonActionPerformed

    private void fillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillButtonActionPerformed

        if (fillButton.isSelected()) {

            controller.setMode(Mode.FILL);

        } else {
            controller.resetMode();
        }
    }//GEN-LAST:event_fillButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if (deleteButton.isSelected()) {
            controller.setMode(Mode.DELETE);
        } else {
            controller.resetMode();
        }

    }//GEN-LAST:event_deleteButtonActionPerformed

    private void lineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineButtonActionPerformed
        if (lineButton.isSelected()) {
            controller.setMode(Mode.INSERT_LINE);
        } else {
            controller.resetMode();
        }
    }//GEN-LAST:event_lineButtonActionPerformed

    private void brushStrokeMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brushStrokeMenuActionPerformed
        int stroke = Integer.valueOf((String) brushStrokeMenu.getSelectedItem());
        controller.setBrushStroke(stroke);
    }//GEN-LAST:event_brushStrokeMenuActionPerformed

    private void lineStrokeMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineStrokeMenuActionPerformed
        int stroke = Integer.valueOf((String) lineStrokeMenu.getSelectedItem());
        controller.setLineStroke(stroke);
    }//GEN-LAST:event_lineStrokeMenuActionPerformed

    private void colorPickerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorPickerButtonActionPerformed
        controller.colorPicker();
    }//GEN-LAST:event_colorPickerButtonActionPerformed

    private void mousePointerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mousePointerButtonActionPerformed
        controller.setMode(Mode.DEFAULT);
    }//GEN-LAST:event_mousePointerButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JPanel background;
    private javax.swing.JToggleButton brushButton;
    private javax.swing.JLabel brushStrokeLabel;
    private javax.swing.JLabel brushStrokeLabel1;
    private javax.swing.JComboBox<String> brushStrokeMenu;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JToggleButton circleButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton colorPickerButton;
    private javax.swing.JPanel currentColor;
    private javax.swing.JToggleButton deleteButton;
    private javax.swing.JPanel drawingPanel;
    private javax.swing.JToggleButton ellispeButton;
    private javax.swing.JToggleButton eraserButton;
    private javax.swing.JComboBox<String> eraserSizeMenu;
    private javax.swing.JToggleButton fillButton;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler10;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.Box.Filler filler8;
    private javax.swing.Box.Filler filler9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToggleButton lineButton;
    private javax.swing.JLabel lineStrokeLabel;
    private javax.swing.JComboBox<String> lineStrokeMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JToggleButton mousePointerButton;
    private javax.swing.JToggleButton moveButton;
    private javax.swing.JMenuItem newProjectMenuItem;
    private javax.swing.JToggleButton pencilButton;
    private javax.swing.JToggleButton rectangleButton;
    private javax.swing.JButton redoButton;
    private javax.swing.JMenuItem redoButtonMenu;
    private javax.swing.JPopupMenu rightClickMenu;
    private javax.swing.JMenuItem saveProjectMenuItem;
    private javax.swing.JToolBar sideBar;
    private javax.swing.JToggleButton squareButton;
    private javax.swing.JToolBar topBar;
    private javax.swing.JToggleButton triangleButton;
    private javax.swing.JButton undoButton;
    private javax.swing.JMenuItem undoButtonMenu;
    // End of variables declaration//GEN-END:variables
}
