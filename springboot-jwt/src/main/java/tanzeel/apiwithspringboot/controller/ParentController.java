package tanzeel.apiwithspringboot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import tanzeel.apiwithspringboot.model.Parent;
import tanzeel.apiwithspringboot.repository.ParentRepository;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@Tag(name = "Parent", description = "Parent controller")
public class ParentController {

    final
    private ParentRepository parentRepository;

    public ParentController(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @Operation(summary = "Find all parents", description = "All parents", tags = { "parent" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Parent.class)))) })
    @GetMapping("/parent")
    public List<Parent> index(){
        return parentRepository.findAll();
    }



    @Operation(summary = "Find parent by id", description = "Find parent by id", tags = { "parent" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = Parent.class))) })
    @GetMapping("/parent/{id}")
    public Parent show(@PathVariable String id){
        int parentId = Integer.parseInt(id);
        return parentRepository.findById(parentId).orElse(new Parent());
    }
//
//    @PostMapping("/parent/search")
//    @Operation(summary = "search parent by text in title", description = "Find parent by text in title", tags = { "parent" })
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "successful operation",
//                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Parent.class)))) })
//    public List<Parent> search(@RequestBody Map<String, String> body){
//        String searchTerm = body.get("text");
//        return parentRepository.findByTitleContainingOrContentContaining(searchTerm, searchTerm);
//    }
//
//
    @Operation(summary = "Create a new parent", description = "Create a new parent", tags = { "parent" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = Parent.class))) })
    @PostMapping("/parent")
    public Parent create(@RequestBody Map<String, String> body){
        String email = body.get("email");
        String firstname = body.get("firstname");
        String lastname = body.get("lastname");
        return parentRepository.save(new Parent(email, firstname, lastname));
    }
//
//
//    @Operation(summary = "Update a new parent", description = "Update a new parent", tags = { "parent" })
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "successful operation",
//                    content = @Content(schema = @Schema(implementation = Parent.class))) })
//    @PutMapping("/parent/{id}")
//    public Parent update(@PathVariable String id, @RequestBody Map<String, String> body){
//        int parentId = Integer.parseInt(id);
//        // getting parent
//        Parent parent = parentRepository.findById(parentId).orElse(new Parent());
//        parent.setEmail(body.get("email"));;
//        parent.setFirstname(body.get("firstname"));
//        parent.setLastname(body.get("lastname"));
//        return parentRepository.save(parent);
//    }
//
//
//    @Operation(summary = "Delete a  parent", description = "Delete a parent", tags = { "parent" })
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "successful operation",
//                    content = @Content(schema = @Schema(implementation =  Boolean.class))) })
//    @DeleteMapping("parent/{id}")
//    public boolean delete(@PathVariable String id){
//        int parentId = Integer.parseInt(id);
//        parentRepository.deleteById(parentId);
//        return true;
//    }

}
