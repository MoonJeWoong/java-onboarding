package onboarding;

import java.util.*;

class People implements Comparable<People>{
    String name;
    boolean userFriendStatus = false;
    ArrayList<String> friendList = new ArrayList<>();
    int score=0;

    public People(String name){
        this.name = name;
    }

    public boolean isZeroScore(){
        if(this.score==0) return true;
        return false;
    }

    public void setUserFriendStatus(boolean userFriendStatus){
        this.userFriendStatus=userFriendStatus;
    }

    public boolean getUserFriendStatus(){
        return this.userFriendStatus;
    }

    public void addToFriendList(String friendName){
        friendList.add(friendName);
    }

    public void addScore(int score){
        this.score += score;
    }

    @Override
    public int compareTo(People o){
        if(o.score==this.score) return this.name.compareTo(o.name);
        return o.score-this.score;
    }
}

public class Problem7 {

    public void putPeopleToMap(HashMap<String,People> map, String peopleName){
        if(!map.containsKey(peopleName)){
            map.put(peopleName, new People(peopleName));
        }
    }

    public void addFriendToPeople(String user, People people, String friendName){
        people.addToFriendList(friendName);
        if(friendName.equals(user)){
            people.setUserFriendStatus(true);
        }
    }

    public void removeUserFriend(HashMap<String,People> map, String name){
        if(map.containsKey(name) && map.get(name).getUserFriendStatus()){
            map.remove(name);
        }
    }

    public HashMap<String, People> makePeopleMap(String user, List<List<String>> friends, List<String> visitors){
        HashMap<String,People> map = new HashMap<>();
        map.put(user, new People(user));
        for(List<String> friend : friends){
            String name1 = friend.get(0);
            String name2 = friend.get(1);

            putPeopleToMap(map, name1);
            addFriendToPeople(user, map.get(name1), name2);

            putPeopleToMap(map, name2);
            addFriendToPeople(user, map.get(name2), name1);
        }

        for(String visitor : visitors) {
            putPeopleToMap(map, visitor);
        }

        for(String name : map.keySet().toArray(new String[0])){
            removeUserFriend(map, name);
        }
        return map;
    }

    public void scoreToUserFriend(ArrayList<String> userFriendsList, People person){
        for(String personFriend : person.friendList){
            if(userFriendsList.contains(personFriend)){
                person.addScore(10);
            }
        }
    }

    public void calculateFriendsScore(String user, HashMap<String, People> map){
        ArrayList<String> userFriendsList = map.get(user).friendList;
        if(userFriendsList.isEmpty()) return;
        for(People person : map.values()){
            scoreToUserFriend(userFriendsList, person);
        }
    }

    public void calculateVisitorsScore(String user, HashMap<String, People> map, List<String> visitors){

    }

    public void addEmailToList(String user, People person,  ArrayList<String> recommendedList){

    }

    public ArrayList<String> makeRecommendedList(String user, HashMap<String, People> map){
        ArrayList<String> recommendedList = new ArrayList<>();
        return recommendedList;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Problem7 T = new Problem7();

        HashMap<String, People> map = T.makePeopleMap(user, friends, visitors);
        T.calculateFriendsScore(user, map);
        T.calculateVisitorsScore(user, map, visitors);
        ArrayList<String> answer = T.makeRecommendedList(user, map);

        return answer;
    }
}

