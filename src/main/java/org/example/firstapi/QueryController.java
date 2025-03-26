package org.example.firstapi;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api") // Группировка запросов в /api
public class QueryController {

    private final JdbcTemplate jdbcTemplate; //Константа для подключение к БД

    @Autowired
    public QueryController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody UserRequest userRequest) {
        String sql = "INSERT INTO users (id, name, surname, email, phone, birthd) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, userRequest.getId(), userRequest.getName(), userRequest.getSurname(), userRequest.getEmail(), userRequest.getPhone(), userRequest.getBirthd());

        String sql2 = "INSERT INTO role (id, role) VALUES (?, ?)";
        jdbcTemplate.update(sql2, userRequest.getId(), userRequest.getRole());

        return "User " + userRequest.getName() + " added successfully!";
    }

    @PostMapping("/addBook")
    public String addBook(@RequestBody UserRequest userRequest) {
        String sql = "INSERT INTO fullnameofbooks (namebooks, yearofpub) VALUES (?, ?)";
        jdbcTemplate.update(sql, userRequest.getNameofbooks(), userRequest.getYearofpub());

        String sql2 = "INSERT INTO ganer (ganer) VALUES (?)";
        jdbcTemplate.update(sql2, userRequest.getGaner());

        String sql3 = "INSERT INTO author (author) VALUES (?)";
        jdbcTemplate.update(sql3, userRequest.getAuthor());

        return "Book " + userRequest.getNameofbooks() + " added successfully!";
    }

    @GetMapping("/getUsers")
    public List<Map<String, Object>> getUsers() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.queryForList(sql);
    }

    @GetMapping("/getBooks")
    public List<Map<String, Object>> getBooks() {
        String sql = "SELECT * FROM fullnameofbooks";
        return jdbcTemplate.queryForList(sql);
    }

    @DeleteMapping("/deleteUsers")
    public String deleteUsers(@RequestBody UserRequest userRequest) {
        String sql = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(sql, userRequest.getId());
        return "User deleted.";
    }

    @DeleteMapping("/deleteAllUsers")
    public String deleteAllUsers() {
        String sql = "DELETE FROM users";
        jdbcTemplate.update(sql);
        String sql2 = "DELETE FROM role";
        jdbcTemplate.update(sql2);
        return "User deleted.";
    }

    @DeleteMapping("/deleteAllBooks")
    public String deleteAllBooks() {
        String sql = "DELETE FROM books";
        jdbcTemplate.update(sql);
        return "Book deleted.";
    }

    @DeleteMapping("/deleteBooks")
    public String deleteBooks(@RequestBody UserRequest userRequest) {
        String sql = "DELETE FROM fullnameofbooks WHERE id = ?";
        jdbcTemplate.update(sql);
        return "Books deleted.";
    }

    @PatchMapping("/redactUser")
    public String updateUsers(@RequestBody UserRequest userRequest) {
        String sql = "UPDATE users SET name = ?,surname = ?, email = ?, phone = ?, birthd = ? WHERE id = ?";
        jdbcTemplate.update(sql,  userRequest.getName(), userRequest.getSurname(), userRequest.getEmail(), userRequest.getPhone(), userRequest.getBirthd(), userRequest.getId());

        String sql2 = "UPDATE role SET role = ? WHERE id = ?";
        jdbcTemplate.update(sql2, userRequest.getRole(), userRequest.getId());

        return "User " + userRequest.getName() + " updated successfully!";
    }

    @PatchMapping("/redactBook")
    public String updateBooks(@RequestBody UserRequest userRequest) {
        String sql = "UPDATE fullnameofbooks SET namebooks = ?, yearofpub = ? WHERE id = ?";
        jdbcTemplate.update(sql, userRequest.getId(), userRequest.getNameofbooks(), userRequest.getYearofpub());

        String sql2 = "UPDATE ganer SET ganer = ? WHERE id = ?";
        jdbcTemplate.update(sql2, userRequest.getId(), userRequest.getGaner());

        String sql3 = "UPDATE author SET author = ? WHERE id = ?";
        jdbcTemplate.update(sql3, userRequest.getId(), userRequest.getAuthor());

        return "Book " + userRequest.getName() + " updated successfully!";
    }
}
