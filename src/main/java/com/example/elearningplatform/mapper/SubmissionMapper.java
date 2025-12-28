package com.example.elearningplatform.mapper;

import com.example.elearningplatform.dto.submission.SubmissionRequestDTO;
import com.example.elearningplatform.dto.submission.SubmissionResponseDTO;
import com.example.elearningplatform.model.Submission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubmissionMapper {
    @Mapping(source = "assignmentId", target = "assignment.id")
    @Mapping(source = "studentId", target = "student.id")
    Submission toEntity(SubmissionRequestDTO dto);

    @Mapping(source = "assignment.id", target = "assignmentId")
    @Mapping(source = "student.id", target = "studentId")
    @Mapping(source = "submittedAt", target = "submittedAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    SubmissionResponseDTO toResponseDTO(Submission submission);
}