package com.coral.cgs.calculation;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by ccc on 2018/5/23.
 */
public final class RatingNode {

    private RatingNode parent;
    private RatingNode root;
    private List<RatingNode> children;
    private List<RatingAdjust> ratingAdjusts;
    private Map<String, List<RatingAdjust>> ratingStageAdjustMap = Maps.newHashMap();
    private String name;
    private boolean leafNode = false;
    private int level = 0;
    private BigDecimal currentValue;
    private Map<String, BigDecimal> stageValueMap = Maps.newHashMap();
    /*private Map<RatingStage, BigDecimal> ratingStageFactorMap = new HashMap<>();*/


    RatingNode(RatingNode parent) {
        this.setParent(parent);
    }

    public void addStageValue(RatingStage ratingStage, BigDecimal value) {
        stageValueMap.put(ratingStage.getName(),value);
    }

    private void setParent(RatingNode newParent) {
        if (parent != null)
            parent.removeChild(this);
        parent = newParent;
        if (parent != null) {
            parent.addChildNode(this);
            setLevel(parent.getLevel() + 1);
        }
    }

    public boolean hasChild() {
        if(children != null && children.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void addChildNode(RatingNode ratingNode) {
        if(!leafNode) {
            if (children == null) {
                children = new ArrayList<RatingNode>();
            }
            children.add(ratingNode);
        }
    }

    private void removeChild(RatingNode preChild) {
        if (children == null)
            return;
        children.remove(preChild);
    }

    public void addRatingAdjust(RatingAdjust ratingAdjust) {
        if(ratingAdjusts == null) {
            ratingAdjusts = new ArrayList<RatingAdjust>();
        }
        ratingAdjusts.add(ratingAdjust);
        RatingStage ratingStage = ratingAdjust.getRatingStage();
        List<RatingAdjust> ratingAdjustForStageList =ratingStageAdjustMap.get(ratingStage.getName());
        if(ratingAdjustForStageList == null) {
            ratingAdjustForStageList = Lists.newArrayList();
        }
        ratingAdjustForStageList.add(ratingAdjust);
        ratingStageAdjustMap.put(ratingStage.getName(), ratingAdjustForStageList);
    }

    public List<RatingAdjust> getCurrentAdjustByStage(RatingStage ratingStage) {
        return ratingStageAdjustMap.get(ratingStage.getName());
    }

    public Iterable<RatingNode> getAllLeaves() {
        return Iterables.filter(getAllChildren(false, true), new Predicate<RatingNode>() {
            @Override
            public boolean apply(RatingNode input) {
                return input.isLeafNode();
            }
        });
    }

    public List<RatingNode> getAllChildren(
            boolean includeThis, boolean isDepthFirst) {
        if(isLeafNode()) {
            return Collections.emptyList();
        }
        LinkedList<RatingNode> children = Lists.newLinkedList();
        Stack<RatingNode> stack = new Stack<RatingNode>();
        stack.push(this);
        while (!stack.isEmpty()) {
            RatingNode currentItem = stack.pop();
            if (isDepthFirst) {
                children.addFirst(currentItem);
            } else {
                children.addLast(currentItem);
            }
            for (RatingNode item : currentItem.getChildren()) {
                stack.push(item);
            }
        }
        if (!includeThis) {
            children.remove(this);
        }
        return children;
    }

    public RatingNode getParent() {
        return parent;
    }

    public RatingNode getRoot() {
        return root;
    }

    public void setRoot(RatingNode root) {
        this.root = root;
    }

    public List<RatingNode> getChildren() {
        return children;
    }

    public void setChildren(List<RatingNode> children) {
        this.children = children;
    }

    public List<RatingAdjust> getRatingAdjusts() {
        return ratingAdjusts;
    }

    public void setRatingAdjusts(List<RatingAdjust> ratingAdjusts) {
        this.ratingAdjusts = ratingAdjusts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLeafNode() {
        return leafNode;
    }

    public void setLeafNode(boolean leafNode) {
        this.leafNode = leafNode;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String toString() {
        String tree = name + "\n";
        if(currentValue != null) {
            tree = name + "[Price = " + currentValue + "]\n";
        }
        /*String levelSymbol = Collections.nCopies(level,"\t") +;*/
        String leafSymbol =new String(new char[level]).replace("\0", "\t") + "|- ";
        if(children != null) {
            for (RatingNode child : children) {
                tree += leafSymbol + child.toString();
            }
        }
        return tree;
    }

    public BigDecimal getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(BigDecimal currentValue) {
        this.currentValue = currentValue;
    }

    public Map<String, BigDecimal> getStageValueMap() {
        return stageValueMap;
    }

    public void setStageValueMap(Map<String, BigDecimal> stageValueMap) {
        this.stageValueMap = stageValueMap;
    }
}
