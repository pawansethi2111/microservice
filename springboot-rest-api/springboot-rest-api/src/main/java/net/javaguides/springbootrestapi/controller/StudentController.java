package net.javaguides.springbootrestapi.controller;


import net.javaguides.springbootrestapi.bean.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("students")

public class StudentController {

  @GetMapping("student")
  public ResponseEntity<Student>getStudent(){
    Student student  = new Student (
      id : 1,
      firstName : "Ramesh",
      lastName : "Fadatre"
    );
    //return new ResponseEntity<>(student, HttpStatus.OK);
    return ResponseEntity.ok().header(headerName: "custom -header",headerValues : "ramesh").body(student);
  }
  //http://localhost:8080/students

  @GetMapping("students")
  public ResponseEntity <Student> studentPathVariable(@PathVariable("id") int studentId,
                                                      @PathVariable("first-name"),
                                                      String firstName,
                                                      @PathVariable("last-name"),
                                                      String lastName)
  {
    Student student = new Student(studentId,firstName,lastName);
    return ResponseEntity.ok(student);

    @GetMapping("students/query")

      public Student studentRequestVariable
    List<Student>students = new ArrayList<>();
    students.add(new Student(id: 1, firstName: "Ramesh", lastName: "Fadatre"));
    students.add(new Student(id:2, firstName:"umesh", lastname: "Fadatre"));
    students.add(new Student(id:3, firstName: "Ram", lastName: "Jadhav"));
    students.add( new Student(id :4, firstName: "Sanjay", lastName: "Pawar"));
    return students;
  }
  @GetMapping("students/{id}/{first-name}/{last-name}")
  public Student studentPathVariable(@PathVairable("id") int studentId, @PathVariable ("first-name")String firstName,@PathVariable ("last-name")String lastName){
    return new Student(studentId, firstName, lastName);

    @GetMapping("students/query")
    public Student studentRequestVariable(  @RequestParam int id,
                                            @RequestParam String firstName,
                                            @RequestParam  String lastName)
    {
      return new Student(id, firstName, lastName);
    }

    @PostMapping("students/create")

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("students/{id}update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id")
    int student){
      System.out.println(student.getFirstName());
      System.out.println(student.getLastName());
      return ResponseEntity.ok(student);

    }

    public ResponseEntity<Student>createStudent(@RequestBody Student student){
      System.out.println(student.getId());
      System.out.println(student.getfirstName());
      System.out.println(student.getLastName());

      return new ResponseEntity<>(student,HttpStatus.CREATED);
    }
    public Student createStudent(@RequestBody Student student)
    {
      System.out.println(student.getId());
      System.out.println(student.getFirstName());
      System.out.println(student.getLastName());
      return student;
    }

      @PutMapping("students/{id}/update")
      public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId)
    {
      System.out.println(student.getFirstName());
      System.out.println(student.getLastName());
      return student;
    }

    @DeleteMapping("students/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId){
      System.out.println(studentId);
      return "Student deleted successfully!";
    }
  }
}
