/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.uni.edu.programacion.Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import ni.uni.edu.programacion.views.FrmTreeDemo;

/**
 *
 * @author Sistemas-11
 */
public class FrmTreeController {
    private FrmTreeDemo frmTreeDemo;
    private DefaultTreeModel treeModel;
    private DefaultMutableTreeNode root;

    public FrmTreeController(FrmTreeDemo frmTreeDemo) {
        this.frmTreeDemo = frmTreeDemo;
        initComponent();
    }
    
    public void initComponent(){
    root = new  DefaultMutableTreeNode("Accounting", true);
    treeModel = new DefaultTreeModel(root);
    
    
    frmTreeDemo.getTreeAccount().setModel(treeModel);
    
    frmTreeDemo.getBtnAdd().addActionListener((e)->{
     btnAddActionListener(e);
    });
    
    
    
     frmTreeDemo.getBtnRemove().addActionListener((e)->{
       btnRemoveActionListener(e);    
    });
    
     frmTreeDemo.getTreeAccount().addMouseListener(new MouseAdapter() {
     public void mouseClicked(MouseEvent e){
     treeAccountMouseListener(e);
     }
     });
    
    }

    
    
 
    
    
    public void btnAddActionListener(ActionEvent e) {
       
        TreePath treePath = frmTreeDemo.getTreeAccount().getSelectionPath();
        if(treePath == null){
        return;
        }
        
        DefaultMutableTreeNode node= (DefaultMutableTreeNode) treePath.getLastPathComponent();
        
        String accountName = JOptionPane.showInputDialog(null, "Account Name", "Input Dialog", JOptionPane.INFORMATION_MESSAGE);
        
        node.insert(new DefaultMutableTreeNode(accountName), node.getChildCount());
    }                                                                 

    public void btnRemoveActionListener(ActionEvent e) {
        DefaultMutableTreeNode node = getSelectedNode();
    if(node == null ){
    return;
   }

    treeModel.removeNodeFromParent(node);
    
  
   }
    
    public void treeAccountMouseListener(MouseEvent e){
    if(e.getButton()== MouseEvent.BUTTON3){
   // frmTreeDemo.getTreeAccount().getS
    
    frmTreeDemo.getPmniTree().show(frmTreeDemo.getTreeAccount(), e.getX(), e.getY());
            
    }
    
    }

    private DefaultMutableTreeNode getSelectedNode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    }


