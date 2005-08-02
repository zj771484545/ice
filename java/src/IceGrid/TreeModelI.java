// **********************************************************************
//
// Copyright (c) 2003-2005 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
package IceGrid;

import java.util.EventListener;

import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import javax.swing.event.EventListenerList;
import javax.swing.event.TreeModelListener;
import javax.swing.event.TreeModelEvent;

import IceGrid.TreeNode.NodeViewRoot;
import IceGrid.TreeNode.ApplicationViewRoot;

public class TreeModelI implements TreeModel
{
    public Object getRoot()
    {
	return _root;
    }
    
    public Object getChild(Object parent, int index) 
    {
	return ((IceGrid.TreeNode.CommonBase)parent).getChildAt(index);
    }
    
    public int getChildCount(Object parent)
    {
	return ((IceGrid.TreeNode.CommonBase)parent).getChildCount();
    }
    
    public boolean isLeaf(Object node)
    {
	return ((IceGrid.TreeNode.CommonBase)node).isLeaf();
    }
    
    public void valueForPathChanged(TreePath path, Object newValue)
    {
	// TODO: implement
    }
    
    public int getIndexOfChild(Object parent, Object child)
    {
	if(parent == null)
	{
	    return -1;
	}
	else
	{
	    return ((IceGrid.TreeNode.CommonBase)parent).getIndex(child);
	}
    }
    
    public void addTreeModelListener(TreeModelListener listener) 
    {
	_listenerList.add(TreeModelListener.class, listener);
    }
    
    public void removeTreeModelListener(TreeModelListener listener)
    {
	_listenerList.remove(TreeModelListener.class, listener);
    }
    
    TreeModelI(Object root)
    {
	_root = root;
    }
    
    public void fireNodesChangedEvent(TreeModelEvent e)
    {
	// Guaranteed to return a non-null array
        Object[] listeners = _listenerList.getListenerList();
	
        for(int i = listeners.length - 2; i >=0 ; i -= 2)
	{
            if (listeners[i] == TreeModelListener.class) 
	    {
                ((TreeModelListener)listeners[i + 1]).treeNodesChanged(e);
            }          
        }
    }
    
    public void fireStructureChangedEvent(TreeModelEvent e)
    {
	// Guaranteed to return a non-null array
        Object[] listeners = _listenerList.getListenerList();
	
        for(int i = listeners.length - 2; i >=0 ; i -= 2)
	{
            if (listeners[i] == TreeModelListener.class) 
	    {
                ((TreeModelListener)listeners[i + 1]).treeStructureChanged(e);
            }          
        }
    }
    
    public void fireNodesInsertedEvent(TreeModelEvent e)
    {
	// Guaranteed to return a non-null array
        Object[] listeners = _listenerList.getListenerList();
	
        for(int i = listeners.length - 2; i >=0 ; i -= 2)
	{
            if (listeners[i] == TreeModelListener.class) 
	    {
                ((TreeModelListener)listeners[i + 1]).treeNodesInserted(e);
            }          
        }
    }

    public void fireNodesRemovedEvent(TreeModelEvent e)
    {
	// Guaranteed to return a non-null array
        Object[] listeners = _listenerList.getListenerList();
	
        for(int i = listeners.length - 2; i >=0 ; i -= 2)
	{
            if (listeners[i] == TreeModelListener.class) 
	    {
                ((TreeModelListener)listeners[i + 1]).treeNodesRemoved(e);
            }          
        }
    }
    
    private Object _root;
    private EventListenerList _listenerList = new EventListenerList();
}

